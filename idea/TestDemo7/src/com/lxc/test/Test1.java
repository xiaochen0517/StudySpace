package com.lxc.test;

public class Test1 {
    public static void main(String[] args) {
        String a = "xiaochenf213@qq342.co1m";
        String b = "[a-zA-Z0-9]*@[a-zA-Z0-9]*\\.[a-zA-Z]*";
        System.out.println(a.matches(b));
    }
}
