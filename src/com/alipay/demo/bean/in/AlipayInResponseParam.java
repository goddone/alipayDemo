/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.Result;
import com.alipay.demo.bean.ResultBase;
import com.alipay.demo.bean.ResultSetter;

/**
 * 对支付宝向商户发起的请求的响应基类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInResponseParam.java, v 0.1 2014-1-8 下午8:11:42 jie.hua Exp $
 */
public class AlipayInResponseParam extends AlipayInParam implements Result, ResultSetter {

    /**  序列号ID  */
    private static final long serialVersionUID = 1285525230370327867L;
    /**
     * 结果类
     */
    private ResultBase        result;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInResponseParam(String resultCode, String resultMsg) {

        result = new ResultBase(resultCode, resultMsg);

    }

    /** 
     * @see com.alipay.demo.bean.Result#getResultCode()
     */
    @Override
    public String getResultCode() {

        return result.getResultCode();
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
        return result.getResultMsg();
    }

    /** 
     * @see com.alipay.demo.bean.Result#setResultMsg(java.lang.String)
     */
    @Override
    public void setResultMsg(String resultMsg) {

        result.setResultMsg(resultMsg);
    }

    /** 
     * @see com.alipay.demo.bean.Result#isSuccess()
     */
    @Override
    public boolean isSuccess() {

        return result != null && result.isSuccess();
    }

    /** 
     * @see com.alipay.demo.bean.Result#setSuccess(boolean)
     */
    @Override
    public void setSuccess(boolean success) {

        this.result.setSuccess(success);
    }

}
