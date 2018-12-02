package com.welvx.intercity.enums;



public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    CITY_ERROR(100,"未获取到正确的城市信息，请检查出发地或目的地")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
