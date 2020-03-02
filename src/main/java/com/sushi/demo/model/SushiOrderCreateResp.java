package com.sushi.demo.model;

public class SushiOrderCreateResp {
    private String code;
    private String msg;
    private SushiOrder sushiOrder;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SushiOrder getSushiOrder() {
        return sushiOrder;
    }

    public void setSushiOrder(SushiOrder sushiOrder) {
        this.sushiOrder = sushiOrder;
    }
}
