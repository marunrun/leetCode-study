package mr.design.runner;

import mr.design.util.ConsoleReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MetricsRunner implements CommandLineRunner {

    @Autowired
    ConsoleReporter consolereporter;

    @Override
    public void run(String... args) {
        try {
            consolereporter.startRepeatReport(60, 10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
