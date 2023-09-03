package com.hss.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 配置读取
 * </p>
 *
 * @author Hss
 * @date 2023-09-03
 */
@Configuration
@Slf4j
@Data
public class MyConfig {

    @Value(value = "${com.hss.http.url}")
    private String httpUrl;

    @Value(value = "${com.hss.customName}")
    private String customName;

    @Value(value = "${com.hss.mysql.url:#{null }}")
    private String mysqlUrl;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
