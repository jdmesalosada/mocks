package com.mesaj.pocs.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:/application-${environment:dev}.properties")
public class AppConf {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
