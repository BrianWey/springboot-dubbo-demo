package com.msyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 消费者启动器
 * @author: Brian
 * @date: 2019-04-18
 */
@SpringBootApplication
public class ConsumerApplication {

    protected ConsumerApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
