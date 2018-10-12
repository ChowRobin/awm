package pers.robin.awm.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import pers.robin.awm.filter.UserFilter;

import java.util.HashMap;
import java.util.Map;

public class UserFilterConfig {

    @Bean(name = "userFilter")
    public UserFilter userFilter() {
        return new UserFilter();
    }

    @Bean
    public FilterRegistrationBean userFilterBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(userFilter());
        Map<String,String> m = new HashMap<String,String>();
        m.put("targetBeanName","userFilter");
        m.put("targetFilterLifecycle","true");
        registration.setInitParameters(m);
//        registration.addUrlPatterns("/customer/*");
//        registration.addUrlPatterns("/shop/*");
        registration.addUrlPatterns("/**");
        registration.setName("userFilter");

        return registration;
    }
}
