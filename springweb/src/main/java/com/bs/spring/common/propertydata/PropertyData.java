package com.bs.spring.common.propertydata;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource("classpath:myresources.properties")
public class PropertyData {
    @Value("${app.name}")
    private String appName;
    @Value("${dburl}")
    private String dbUrl;
//    @Value("${user}")
//    private String user;
//    @Value("${pw}")
//    private String pw;
//    @Value("${dirverName}")
//    private String driverName;

    @Value("${data.students}")
    private String students;
}
