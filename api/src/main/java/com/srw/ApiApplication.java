package com.srw;

import com.dtflys.forest.annotation.ForestScan;
import com.srw.business.UserService;
import com.srw.controller.TestController;
import com.srw.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@ForestScan(basePackages = "com.srw.client")
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApiApplication.class, args);
        TestController testController = applicationContext.getBean(TestController.class);
        System.out.println(testController.getClass());
    }

}
