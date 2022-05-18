package com.javatechie.executor.api.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(final Throwable throwable, final Method method, final Object... obj) {
       log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (final Object param : obj) {
            log.info("Param - " + param);
        }
    }

}