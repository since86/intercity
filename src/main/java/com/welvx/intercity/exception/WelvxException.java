package com.welvx.intercity.exception;

public class WelvxException extends RuntimeException {
    private Integer code;
    public WelvxException(Integer code,String msg){
        super(msg);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
