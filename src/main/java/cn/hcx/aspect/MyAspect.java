package cn.hcx.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
    }
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知");
    }
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕开始：");
        Object obj=proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return obj;
    }
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知："+e.getMessage());
    }
    public void myAfter(){
        System.out.println("最终通知");
    }
}

