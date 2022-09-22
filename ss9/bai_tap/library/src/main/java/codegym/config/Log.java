package codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Log {

    @Pointcut("execution(* codegym.controller.BookController.*(..))")
    public void allMethodPointCut(){}

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("START METHOD NAME: "+
                joinPoint.getSignature().getName() +" Time: "+
                LocalDateTime.now());
    }

    @AfterReturning("allMethodPointCut()")
    public void afterThrowingCallMethod(JoinPoint joinPoint){
        System.out.println("END METHOD NAME: "+
                joinPoint.getSignature().getName() +" Time: "+
                LocalDateTime.now());
    }
}
