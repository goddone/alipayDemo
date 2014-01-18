/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

import java.io.Serializable;

/**
 * 结果基类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ResultBase.java, v 0.1 2014-1-6 上午11:28:32 jie.hua Exp $
 */
public class ResultBase extends ToStringBase implements Result, ResultSetter, Serializable {

    /** 序列号ID */
    private static final long serialVersionUID = 5237281206651425532L;

    /**
     * 成功标识
     */
    private boolean           success;

    /**
     * 结果码
     */
    private String            resultCode;

    /**
     * 结果描述
     */
    private String            resultMsg;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ResultBase(String resultCode, String resultMsg) {
        super();
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
     * Setter method for property <tt>resultCode</tt>.
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Setter method for property <tt>resultMsg</tt>.
     * 
     * @param resultMsg value to be assigned to property resultMsg
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    /** 
     * @see com.alipay.demo.bean.Result#isSuccess()
     */
    @Override
    public boolean isSuccess() {

        return this.success;
    }

    /** 
     * @see com.alipay.demo.bean.Result#setSuccess(void)
     */
    @Override
    public void setSuccess(boolean success) {

        this.success = success;
    }

}
