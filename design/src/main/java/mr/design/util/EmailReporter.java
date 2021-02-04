package mr.design.util;


import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class EmailReporter extends ScheduleReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, @Qualifier("emailViewer")StatViewer statViewer) {
        super(metricsStorage, aggregator, statViewer);
    }

    public void startDailyReport() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, getZeroTime(), DAY_HOURS_IN_SECONDS * 1000);
    }

    @VisibleForTesting
    protected Date getZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
