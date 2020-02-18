package com.nghiatn.maven;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nghiatn
 */
@SpringBootApplication(
        exclude = {
                RedisAutoConfiguration.class,
                //
                KafkaAutoConfiguration.class,
                //
                JmsAutoConfiguration.class,
                //
//                HibernateJpaAutoConfiguration.class,
//                DataSourceAutoConfiguration.class,
        }
)
@ComponentScan(
        basePackages = "com.nghiatn.maven.controller",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = GRpcService.class),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
)
public class GrpcTestApp {

    public static void  main(String[] args) {
        SpringApplication.run(GrpcTestApp.class, args);
    }
}
