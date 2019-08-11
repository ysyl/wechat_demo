package com.zjldemo.demo.Enum;

public enum EnumResponseCode {
    SUCCESS(1, "success"), FAILRURE(0, "failure");
    private int code;

    private String msg;

    EnumResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
