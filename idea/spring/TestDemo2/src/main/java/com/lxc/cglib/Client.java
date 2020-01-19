package com.lxc.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class Client {

    @Test
    public void test1(){
        final Producer producer = new Producer();
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                Object object = null;
                if (method.getName().equals("sale")) {
                    object = method.invoke(producer, money * 0.9f);
                }
                return object;
            }
        });
        cglibProducer.sale(1000f);
    }

}
