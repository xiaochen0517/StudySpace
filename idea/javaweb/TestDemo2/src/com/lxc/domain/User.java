package com.lxc.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String name;
    private int age;
    private Date time;

    public String getBirStr(){
        if (time!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            return sdf.format(time);
        }else{
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
