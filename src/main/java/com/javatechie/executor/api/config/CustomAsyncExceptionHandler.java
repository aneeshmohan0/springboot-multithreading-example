package com.javatechie.executor.api.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(final Throwable throwable, final Method method, final Object... obj) {
       log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());

        Arrays.stream(obj).forEach(param -> log.info("Param - " + param));
    }

}