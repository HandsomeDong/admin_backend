package com.handsomedong.manager.vo;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    /** 默认的键 */

    public static final String KEY_SUCCESS = "success";
    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "msg";
    public static final String KEY_DATA = "data";

    /** 默认的值 */

    public static final int DEFAULT_SUCCESS_CODE = 1;
    public static final int DEFAULT_FAILED_CODE = -1;
    public static final String DEFAULT_SUCCESS_MSG = "ok";
    public static final String DEFAULT_FAILED_MSG = "failed";

    /** 最通用的两个构造函数 */

    /**
     * 操作成功
     */
    public Result() {
        this.put(KEY_SUCCESS, true);
        this.put(KEY_CODE, DEFAULT_SUCCESS_CODE);
        this.put(KEY_MSG, DEFAULT_SUCCESS_MSG);
    }

    /**
     * 全参构造
     *
     * @param success
     * @param code
     * @param msg
     * @param data
     */
    public Result(boolean success, int code, String msg, Object data) {
        this.put(KEY_SUCCESS, success);
        this.put(KEY_CODE, code);
        this.put(KEY_MSG, msg);
        if (data != null) {
            this.put(KEY_DATA, data);
        }
    }

    /***静态方法***/

    //操作成功
    public static Result ok() {
        return new Result();
    }

    public static Result ok(String msg) {
        return new Result(true, DEFAULT_SUCCESS_CODE, msg, null);
    }

    public static Result ok(Object data) {
        return new Result(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, data);
    }

    public static Result ok(String key, String value) {
        return new Result(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG, null).data(key, value);
    }

    //操作失败
    public static Result failed() {
        return new Result(false, DEFAULT_FAILED_CODE, DEFAULT_FAILED_MSG, null);
    }

    public static Result failed(String msg) {
        return new Result(false, DEFAULT_FAILED_CODE, msg, null);
    }

    public static Result failed(Object data) {
        return new Result(false, DEFAULT_FAILED_CODE, DEFAULT_FAILED_MSG, data);
    }

    public static Result failed(String key, Object value) {
        return new Result(false, DEFAULT_FAILED_CODE, DEFAULT_FAILED_MSG, null).data(key, value);
    }

    /** 设置操作返回的数据，数据使用自定义的key存储 */
    public Result data(String dataKey, Object dataVal) {
        this.put(dataKey, dataVal);
        return this;
    }
}
