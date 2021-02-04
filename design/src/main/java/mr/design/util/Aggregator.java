package mr.design.util;

import mr.design.entity.valueObject.RequestInfo;
import mr.design.entity.valueObject.RequestStat;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMills) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        requestInfos.forEach((apiName, requestInfo) -> {
            RequestStat requestStat = doAggregate(requestInfo, durationInMills);
            requestStats.put(apiName, requestStat);
        });
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> responseTimes = new ArrayList<>();
        requestInfos.forEach(requestInfo -> responseTimes.add(requestInfo.getResponseTime()));
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(responseTimes));
        requestStat.setMinResponseTime(min(responseTimes));
        requestStat.setAvgResponseTime(avg(responseTimes));
        requestStat.setP999ResponseTime(percentile999(responseTimes));
        requestStat.setP99ResponseTime(percentile99(responseTimes));
        requestStat.setCount(responseTimes.size());
        requestStat.setTps((long) responseTimes.size() / (durationInMillis / 1000));
        return requestStat;
    }

    private double percentile999(List<Double> responseTimes) {
        return responseTimes.get((int) (responseTimes.size() * 0.999));
    }

    private double percentile99(List<Double> responseTimes) {
        return responseTimes.get((int) (responseTimes.size() * 0.99));
    }

    private double avg(List<Double> responseTimes) {
        return responseTimes.stream().mapToDouble(responseTime -> responseTime).average().orElse(Double.NaN);
    }

    private double max(List<Double> responseTimes) {
        return responseTimes.stream().mapToDouble(responseTime -> responseTime).max().orElse(Double.NaN);
    }

    private double min(List<Double> responseTimes) {
        return responseTimes.stream().mapToDouble(responseTime -> responseTime).min().orElse(Double.NaN);
    }
}
