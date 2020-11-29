package com.java.util;

import org.apache.commons.httpclient.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/10
 */
public class YUtil extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public YUtil() {
        put("code", 0);
        put("msg", "success");
    }

    public static YUtil error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员 ");
    }

    public static YUtil error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static YUtil error(int code, String msg) {
        YUtil r = new YUtil();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static YUtil ok(String msg) {
        YUtil r = new YUtil();
        r.put("msg", msg);
        return r;
    }

    public static YUtil ok(Map<String, Object> map) {
        YUtil r = new YUtil();
        r.putAll(map);
        return r;
    }

    public static YUtil ok() {
        return new YUtil();
    }

    public YUtil put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}