package mr.design.util;

import mr.design.entity.valueObject.RequestStat;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis);
}
