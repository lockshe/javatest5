package io.choerodon.choerodonstudyservice24981y;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("io.choerodon")
@EnableEurekaClient
@EnableChoerodonResourceServer
@SpringBootApplication
public class ChoerodonStudyService24981YApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoerodonStudyService24981YApplication.class, args);
    }

}
