package com.xiaocong.questionbank_xiaocong.model.po;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author
 * @version 1.0
 * @description 通用结果类型
 */

@Data
@ToString
public class RestResponse<T> implements Serializable {

    /**
     * 响应编码,0为正常,-1错误
     */
    private int code;

    /**
     * 响应提示信息
     */
    private String msg;

    /**
     * 响应内容
     */
    private Object result;

    public RestResponse() {
    }

    public RestResponse(Object result) {
        this.result = result;
    }
}
