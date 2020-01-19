package com.lxc.proxy;

public class HuaWei implements Phone {
    @Override
    public int create(int money) {
        return money+1000;
    }
}
