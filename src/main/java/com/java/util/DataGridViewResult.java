package com.java.util;


/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/10
 */
public class DataGridViewResult {
    private Integer code=0;
    private String msg="";
    private Long count=0L;
    private Object data;

    public DataGridViewResult(Long count, Object data) {
        super();
        this.count=count;
        this.data=data;
    }

    public DataGridViewResult(Object data) {
        super();
        this.data=data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
