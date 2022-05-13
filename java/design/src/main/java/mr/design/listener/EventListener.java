package mr.design.listener;

import com.google.common.eventbus.Subscribe;
import mr.design.entity.valueObject.RequestInfo;

public class EventListener {
    @Subscribe
    public void saveRequestInfo(RequestInfo requestInfo){

    }
}
