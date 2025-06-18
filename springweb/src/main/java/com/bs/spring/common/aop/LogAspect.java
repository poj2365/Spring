/*
  Created by IntelliJ IDEA.
  User: poj23
  Date: 25. 6. 18.
  Time: 오후 1:24
*/
package com.bs.spring.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

// aspect 객체
// 공통으로 실행할 기능을 가지고 있는 객체
@Slf4j
public class LogAspect {

    // 메소드가 실행할 지점(target / PointCut)
    // 시점(전, 후, 전|후, 에러발생 후, 반환 후 / advice)
    // 메소드를 선언시 선언부가 정해져있음
    // 전|후 => Object 메소드명(ProceedingJoinPoint)
    // 전, 후 -> void 메소드명(JoinPoint):
    // 에러발생 후 -> void 메소드명(JoinPoint, Trheablie)
    // 반환 후
    public void before(JoinPoint joinPoint) {
        log.debug("==== aop befeore advice ====");
    }

    public void after(JoinPoint joinPoint) {
        log.debug("==== aop after advice ====");
    }
    // spring에 적용시키기
    // 1. xml을 이용해서 적용
    // <aop:config> 태그를 이용
    // <aop:before || around || afterReturning || afterThrowing

    // 2. 어노테이션 적용
    // @Aspect @Component를 클래스에 선언
    // 공통 메소드에 @Before, @After, @Around, @AtfterReturnring
}
