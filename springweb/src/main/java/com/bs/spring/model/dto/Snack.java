package com.bs.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Snack implements InitializingBean {
    private String name;
    private int price;
    private double discount;

    //생성 후 실행 메소드
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("snack객체 생성");
    }
}
