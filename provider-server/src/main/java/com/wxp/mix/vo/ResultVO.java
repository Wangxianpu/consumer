package com.wxp.mix.vo;

/**
 * @description: 需要返回给客户端的数据格式
 * @author:  wxp
 * @time:  2022/4/1 21:28
 */
public class ResultVO<T> {
    /**
     * 待返回的数据
     */
    private T data;
    /**
     * 成功标识
     */
    private boolean flag;
    /**
     * 返回信息
     */
    private String msg;

    public ResultVO(T data, boolean flag, String msg){
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
