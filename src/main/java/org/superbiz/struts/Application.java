package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

import static java.util.Collections.singletonList;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        return buildFilterRegistration(0, new SiteMeshFilter());
    }

    @Bean
    public FilterRegistrationBean strutsExecuteFilter() {
        return buildFilterRegistration(1, new StrutsPrepareAndExecuteFilter());
    }


    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(singletonList("/*"));
        registration.setOrder(order);
        return registration;
    }
}
