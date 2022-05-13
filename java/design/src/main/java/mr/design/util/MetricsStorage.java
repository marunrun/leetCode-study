package mr.design.util;

import mr.design.entity.valueObject.RequestInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfo(String apiName, long startTimestamp, long endTimestamp);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp);
}
