package com.lxc.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    @Test
    public void test1(){
        final ProducerImpl producer = new ProducerImpl();

        Producer produceri = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Float money = (Float) args[0];
                        Object object = null;
                        if (method.getName().equals("sale")) {
                            object = method.invoke(producer, money * 0.9f);
                        }
                        return object;
                    }
                });
        produceri.sale(1000f);
    }

}
