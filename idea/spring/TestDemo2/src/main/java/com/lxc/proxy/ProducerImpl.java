package com.lxc.proxy;


public class ProducerImpl implements Producer {


    public void sale(float money){
        System.out.println("销售产品:"+money);
    }

    public void after(float money){
        System.out.println("产品售后:"+money);
    }

}
