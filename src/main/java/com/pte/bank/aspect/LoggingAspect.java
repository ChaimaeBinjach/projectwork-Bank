
package com.pte.bank.aspect;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component

public class LoggingAspect {
    private static Logger logger= Logger.getLogger("com.pte.bank.aspect.LoggingAspect");
    
    @Pointcut("execution (* com.pte.bank.*.*.*(..))")
    public void loggingPointcut(){
    }
    
//    @Around("execution (* com.pte.bank.*.*.*(..))")
    @Around("loggingPointcut()")
    public Object LoggingAdvice(ProceedingJoinPoint pjp) throws Throwable{
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
//        logger.log(Level.INFO, "Inside "+ className+ " class " + methodName +" method is executing." );
        logger.log(Level.INFO, "Inside "+ className+ " class " + methodName +" method is executing.");
        
        return pjp.proceed();
        
 
        
    }
    @Before("execution(* com.pte.bank.controller.*.get*(..))")
    public void logStatementBefore(){
        logger.log(Level.INFO,"Executing");
    }
    @After("execution(* com.pte.bank.*.*.* (..))")
    public void logStatementAfter(){
        logger.log(Level.INFO, "Execution completed");
    }
}
