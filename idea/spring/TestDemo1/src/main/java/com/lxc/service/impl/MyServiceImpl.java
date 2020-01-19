package com.lxc.service.impl;

import com.lxc.service.MyService;
import org.springframework.stereotype.Component;

@Component
public class MyServiceImpl implements MyService {
    public void findAll() {
        System.out.println("find all");
    }
    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
