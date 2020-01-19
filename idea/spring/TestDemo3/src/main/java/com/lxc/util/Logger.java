package com.lxc.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void initLogger(){
        System.out.println("start logger");
    }

    public Object aroundLogger(ProceedingJoinPoint pjp){
        Object o = null;
        try{
            System.out.println("前置通知");
            Object[] args = pjp.getArgs();
            o = pjp.proceed(args);
            System.out.println("后置通知");
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return o;
    }

}
