package mr.design.util;

import mr.design.entity.valueObject.RequestInfo;
import mr.design.entity.valueObject.RequestStat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public abstract class ScheduleReporter {

    MetricsStorage metricsStorage;

    Aggregator aggregator;

    StatViewer statViewer;

    public ScheduleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
    }


    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = startTimeInMillis - endTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = this.metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> aggregate = this.aggregator.aggregate(requestInfos, durationInMillis);
        this.statViewer.output(aggregate, startTimeInMillis, endTimeInMillis);
    }
}
