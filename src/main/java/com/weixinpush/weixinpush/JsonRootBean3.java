package com.weixinpush.weixinpush;

public class JsonRootBean3 {

    private int code;
    private String msg;
    private Result1 result;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setResult(Result1 result) {
        this.result = result;
    }

    public Result1 getResult() {
        return result;
    }

}

class Result1 {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
