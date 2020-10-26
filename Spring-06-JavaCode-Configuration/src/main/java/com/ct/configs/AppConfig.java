package com.ct.configs;

import com.ct.interfaces.ExtraSessions;
import com.ct.services.Java;
import com.ct.services.OfficeHours;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ct")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public Java java() {
        return new Java(extraSessions());
    }

//    @Bean
//    public OfficeHours officeHours(){
//        return new OfficeHours();
//    }

    @Bean
    public ExtraSessions extraSessions() {
        return new OfficeHours();
    }
}
