package com.zjldemo.demo.Common;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private int pageNum;

    private int pageSize;

    private List<T> data;

    public Page(int pageNum, int pageSize, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
