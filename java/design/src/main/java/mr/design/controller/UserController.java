package mr.design.controller;

import lombok.extern.slf4j.Slf4j;
import mr.design.entity.valueObject.RequestInfo;
import mr.design.entity.valueObject.UserVo;
import mr.design.util.Metrics;
import mr.design.util.MetricsCollector;
import mr.design.util.RedisMetricsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserController {

    @Autowired
    RedisMetricsStorage redisMetricsStorage;

    @PostMapping(value = "/register")
    public void register(UserVo user) throws InterruptedException {
        //todo
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        log.info("register success");
    }

    @PostMapping(value = "/login")
    public UserVo login(String telephone, String password) throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        log.info("login success");
        return new UserVo(telephone,password);
    }

}
