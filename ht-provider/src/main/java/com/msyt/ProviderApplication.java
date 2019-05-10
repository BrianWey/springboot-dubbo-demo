package com.msyt;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 消费者启动类
 * author: Brian
 * date: 2019-04-18
 */
@SpringBootApplication
@MapperScan("com.msyt.mapper")
public class ProviderApplication {

    protected ProviderApplication() {
    }

    /**
     * 商品服务提供者主方法
     *
     * @param args 主方法参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
