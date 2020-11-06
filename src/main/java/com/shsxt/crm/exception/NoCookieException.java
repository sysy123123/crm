package com.shsxt.crm.exception;

import com.mchange.v2.lang.StringUtils;

public class NoCookieException extends Exception {
    private String msg;

    public NoCookieException() {
    }

    public NoCookieException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
}
