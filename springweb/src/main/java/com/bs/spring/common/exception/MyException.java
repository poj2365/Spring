package com.bs.spring.common.exception;

import java.time.LocalDateTime;

public class MyException extends RuntimeException{
    private final LocalDateTime triggerTime;
    public MyException(String message, LocalDateTime triggerTime) {
        super(message);
        this.triggerTime = triggerTime;
    }
}
