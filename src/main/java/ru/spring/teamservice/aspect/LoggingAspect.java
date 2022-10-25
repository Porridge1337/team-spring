package ru.spring.teamservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger;

    @Autowired
    public LoggingAspect(Logger logger) {
        this.logger = logger;
    }

    @Before("execution(* ru.spring.teamservice.service.*.*(..))")
    public void logServiceBefore(JoinPoint joinPoint) {
        logger.log(Level.INFO, "Proxy: " + joinPoint.getThis().getClass().getName() + "\n" +
                "Class: " + joinPoint.getTarget().getClass().getName() + "\n" +
                "Call method: " + joinPoint.getSignature().getName() + "\n" +
                "Args method: " + Arrays.stream(joinPoint.getArgs()).
                map(Object::toString).collect(Collectors.joining(", ")));
    }

    @AfterThrowing(
            pointcut = "execution(* ru.spring.teamservice.dao.*.*(..))",
            throwing = "e")
    public void logDaoWhenException(JoinPoint joinPoint, Throwable e) {
        logger.log(Level.SEVERE, "Logging exception on class: " + joinPoint.getTarget().getClass().getName() + "\n" +
                "Method: " + joinPoint.getSignature().getName() + "\n" +
                e.toString());
    }

}
