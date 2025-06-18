package com.bs.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class AnnoBeanTest {
    private double height;
    private double weight;
    @Autowired//의존성 주입
    private TestClass testClass;

    public void test(){
        System.out.println(this.height+" " +testClass.getName());
    }
}
