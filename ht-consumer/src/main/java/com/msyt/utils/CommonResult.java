package com.msyt.utils;

import lombok.Data;
import lombok.ToString;

/**
 * @author Brian
 * @description: 结果集封装
 * @date 4/29/2019
 */

@Data
@ToString
public class CommonResult {

    public static final String SUCCESS = "success";

    public CommonResult() {
        this.code = 1;
        this.timestamp = System.currentTimeMillis();
    }

    public CommonResult(Object data) {
        this.code = 1;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 返回API的状态码
     */
    private int code;
    /**
     * 时间
     */
    private long timestamp;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 信息
     */
    private String message;
}
