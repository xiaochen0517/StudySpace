package com.lxc.factory;

import com.lxc.service.MyService;
import com.lxc.service.impl.MyServiceImpl;

public class StaticFactory {

    public static MyService getMyService(){
        return new MyServiceImpl();
    }

}
