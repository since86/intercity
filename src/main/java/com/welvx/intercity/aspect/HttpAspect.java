package com.welvx.intercity.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.welvx.intercity.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){

    }
}
