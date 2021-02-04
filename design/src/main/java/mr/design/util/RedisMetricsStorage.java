package mr.design.util;

import com.google.gson.Gson;
import mr.design.entity.valueObject.RequestInfo;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RedisMetricsStorage implements MetricsStorage {

    @Resource
    private RedisTemplate<String, RequestInfo> redisTemplate;

    private static final String STORAGE_KEY = "metrics:";

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        Gson gson = new Gson();
        redisTemplate.opsForHash().put(STORAGE_KEY + requestInfo.getApiName(), requestInfo.getTimestamp().toString(), gson.toJson(requestInfo));
    }

    @Override
    public List<RequestInfo> getRequestInfo(String apiName, long startTimestamp, long endTimestamp) {
        ScanOptions.ScanOptionsBuilder scanOptionsBuilder = new ScanOptions.ScanOptionsBuilder();
        Cursor<Map.Entry<Object, Object>> hScan = redisTemplate.opsForHash().scan(STORAGE_KEY + apiName, scanOptionsBuilder.build());
        ArrayList<RequestInfo> requestInfos = new ArrayList<>();
        while (hScan.hasNext()) {
            Map.Entry<Object, Object> next = hScan.next();
            requestInfos.add(handleRedisValue(next));
        }
        try {
            hScan.close();
        } catch (IOException ignore) {
        }
        return requestInfos;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
        HashMap<String, List<RequestInfo>> requestInfos = new HashMap<>();

        Cursor scan = RedisHelper.scan(redisTemplate, STORAGE_KEY + "*", 1000);

        while (scan.hasNext()) {
            String key = scan.next().toString();
            ArrayList<RequestInfo> info = new ArrayList<>();
            Cursor<Map.Entry<Object, Object>> hScan = redisTemplate.opsForHash().scan(key, ScanOptions.scanOptions().build());
            while (hScan.hasNext()) {
                Map.Entry<Object, Object> next = hScan.next();
                info.add(handleRedisValue(next));
            }
            try {
                hScan.close();
            } catch (Exception ignored) {
            }
            requestInfos.put(key.substring(STORAGE_KEY.length()), info);
        }
        try {
            scan.close();
        } catch (Exception ignored) {
        }

        return requestInfos;
    }

    protected RequestInfo handleRedisValue(Map.Entry<Object, Object> data) {
        Gson gson = new Gson();
        return gson.fromJson(data.getValue().toString(), RequestInfo.class);
    }
}
