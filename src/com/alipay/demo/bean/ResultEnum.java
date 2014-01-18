/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 结果码
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ResultEnum.java, v 0.1 2014-1-5 下午8:51:13 jie.hua Exp $
 */
public enum ResultEnum {

    /**
     * 成功
     */
    SUCESS("200", "成功"),

    /**
     * 验签失败
     */
    SIGN_VERIFY_FAIL("300", "验签失败"),

    /**
     * 加签失败
     */
    SIGN_DO_FAIL("301", "加签失败"),

    /**
     * 执行器不存在
     */
    NO_SUCH_EXEUCTOR("500", "%s对应执行器不存在"),

    /**
     * 转换器不存在
     */
    NO_SUCH_CONVERTER("501", "%s对应converter不存在"),

    /**
     * 调用支付宝API异常
     */
    ALIPAY_EXP_EXECUTOR("550", "调用支付宝API异常"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR("8888", "系统异常");

    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    /**
     * 
     * @param resultCode
     * @param resultMsg
     */
    private ResultEnum(String resultCode, String resultMsg) {

        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

}
