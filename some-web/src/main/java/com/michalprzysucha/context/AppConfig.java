package com.michalprzysucha.context;

import com.michalprzysucha.service.CommonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Michal Przysucha
 * @since 2015-03-31
 */
@Configuration
public class AppConfig {

    @Bean
    public CommonService commonService() {
        return new CommonService();
    }
}
