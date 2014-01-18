/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.Result;
import com.alipay.demo.bean.ResultBase;
import com.alipay.demo.bean.ResultSetter;

/**
 * 向支付宝发起请求的响应基类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResponseParam.java, v 0.1 2014-1-10 上午9:40:17 jie.hua Exp $
 */
public class ToAlipayResponseParam extends ToAlipayParam implements Result, ResultSetter {

    /** 序列号ID */
    private static final long serialVersionUID = 1046775829900071258L;
    /**
     * 结果类
     */
    private ResultBase        result;

    /**
     * @param result
     */
    public ToAlipayResponseParam(String resultCode, String resultMsg) {
        super();
        result = new ResultBase(resultCode, resultMsg);

    }

    /** 
     * @see com.alipay.demo.bean.Result#getResultCode()
     */
    @Override
    public String getResultCode() {
        return this.result.getResultCode();
    }

    /** 
     * @see com.alipay.demo.bean.Result#setResultCode(java.lang.String)
     */
    @Override
    public void setResultCode(String resultCode) {

        this.result.setResultCode(resultCode);

    }

    /** 
     * @see com.alipay.demo.bean.Result#getResultMsg()
     */
    @Override
    public String getResultMsg() {
        return this.result.getResultMsg();
    }

    /** 
     * @see com.alipay.demo.bean.Result#setResultMsg(java.lang.String)
     */
    @Override
    public void setResultMsg(String resultMsg) {

        this.result.setResultMsg(resultMsg);
    }

    /** 
     * @see com.alipay.demo.bean.Result#isSuccess()
     */
    @Override
    public boolean isSuccess() {

        return this.result != null && this.result.isSuccess();
    }

    /** 
     * @see com.alipay.demo.bean.Result#setSuccess(boolean)
     */
    @Override
    public void setSuccess(boolean success) {

        this.result.setSuccess(success);

    }

}
