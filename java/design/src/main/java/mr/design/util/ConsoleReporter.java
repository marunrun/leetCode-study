package mr.design.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ConsoleReporter extends ScheduleReporter {

    protected ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, @Qualifier("consoleViewer") StatViewer statViewer) {
        super(metricsStorage, aggregator, statViewer);
    }

    public void startRepeatReport(long period, long durationInMillis) {
        executor.scheduleAtFixedRate(() -> {
            long startTimeInMillis = System.currentTimeMillis();
            long endTimeInMillis = System.currentTimeMillis() - durationInMillis;
            doStatAndReport(startTimeInMillis, endTimeInMillis);
        }, 0, period, TimeUnit.SECONDS);
    }
}
