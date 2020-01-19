package com.lxc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        HuaWei huaWei = new HuaWei();

        Phone phone = (Phone) Proxy.newProxyInstance(huaWei.getClass().getClassLoader(),
                huaWei.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("phone proxy");
                    System.out.println(method.getName());
                    Object invoke = method.invoke(huaWei,args1[0]);
                    return invoke;
                });
        int i = phone.create(1000);
        System.out.println(i);
    }

}
