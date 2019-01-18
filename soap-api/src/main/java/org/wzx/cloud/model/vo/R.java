package org.wzx.cloud.model.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
        put("data", "操作成功");
    }

    public static R error() {
        return error(500, "操作失败");
    }

    public static R error(Object data) {
        return error(500, data);
    }

    public static R error(int code, Object data) {
        R r = new R();
        r.put("code", code);
        r.put("data", data);
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("code", 200);
        r.put("data", data);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.put("code", 200);
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R ok(List<Map<String, Object>> list) {
        R r = new R();
        r.put("code", 200);
        r.put("data", list);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
