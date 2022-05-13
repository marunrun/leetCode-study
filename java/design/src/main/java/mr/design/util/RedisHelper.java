package mr.design.util;

import org.springframework.data.redis.core.*;

import java.util.Map;

public class RedisHelper {
    public static <K,V> Cursor<Map<K,V>> scan(RedisTemplate<K, V> redisTemplate, String pattern, int limit) {
        ScanOptions scanOptions = ScanOptions.scanOptions().match(pattern).count(limit).build();
        return  (Cursor<Map<K,V>>) redisTemplate.executeWithStickyConnection(connection -> new ConvertingCursor<>(connection.scan(scanOptions),redisTemplate.getKeySerializer()::deserialize));
    }
}
