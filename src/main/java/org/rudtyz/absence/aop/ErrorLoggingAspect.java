package org.rudtyz.absence.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ErrorLoggingAspect {
    @Before("execution(* org.rudtyz.absence.error.ErrorController.*(..))")
    void writeLog(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length == 2) {
            HttpServletRequest req = (HttpServletRequest)args[0];
            Exception ex = (Exception)args[1];
            System.out.println("ErrorLoggingAspect " +
                    req.getMethod() + " " +
                    req.getRequestURL().toString() + " " +
                    req.getRemoteAddr() + " " + ex.toString());
        }
    }
}
