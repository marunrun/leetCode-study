package mr.design;

import mr.design.util.ConsoleReporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }

}
