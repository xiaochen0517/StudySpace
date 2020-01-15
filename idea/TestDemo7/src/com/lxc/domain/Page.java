package com.lxc.domain;

public class Page {

    int allRowsCount;//总行数

    int allPageCount;//总页数

    int locaPageCount;//所在页

    public int getAllRowsCount() {
        return allRowsCount;
    }

    public void setAllRowsCount(int allRowsCount) {
        this.allRowsCount = allRowsCount;
    }

    public int getAllPageCount() {
        return allPageCount;
    }

    public void setAllPageCount(int allPageCount) {
        this.allPageCount = allPageCount;
    }

    public int getLocaPageCount() {
        return locaPageCount;
    }

    public void setLocaPageCount(int locaPageCount) {
        this.locaPageCount = locaPageCount;
    }
}
