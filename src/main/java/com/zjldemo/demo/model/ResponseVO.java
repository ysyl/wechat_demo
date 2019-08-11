package com.zjldemo.demo.model;

import com.zjldemo.demo.Enum.EnumResponseCode;

import java.io.Serializable;

public class ResponseVO<T> implements Serializable {
    private int code = 0;

    private String msg = "";

    private T result = null;

    public static <T> ResponseVO<T> success(T result) {
        return new ResponseVO<>(EnumResponseCode.SUCCESS.getCode(), EnumResponseCode.SUCCESS.getMsg(), result);
    }

    public ResponseVO(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
