package mr.design.util;

import mr.design.entity.valueObject.RequestStat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class EmailViewer implements StatViewer{

    private EmailSender emailSender;
    private List<String> addressed = new ArrayList<>();

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMillis) {

    }
}
