package mr.design.util;

import com.google.gson.Gson;
import mr.design.entity.valueObject.RequestStat;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsoleViewer implements StatViewer {

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
