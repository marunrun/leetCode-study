package mr.design.util;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import mr.design.entity.valueObject.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.EventListener;
import java.util.concurrent.Executors;

@Component
public class MetricsCollector {

    private EventBus eventBus;

    @Autowired
    private MetricsStorage metricsStorage;

    public MetricsCollector() {
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));
        this.eventBus.register(new EventListener() {
        });
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
