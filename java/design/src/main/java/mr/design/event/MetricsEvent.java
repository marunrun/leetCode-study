package mr.design.event;


import org.springframework.context.ApplicationEvent;

public class MetricsEvent extends ApplicationEvent {
    public MetricsEvent(Object source) {
        super(source);
    }
}
