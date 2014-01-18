/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 * 
 * 绑定外部户业务响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAddAccountModelReponse.java, v 0.1 2014-1-10 下午7:40:10 jie.hua Exp $
 */
public class ToAlipayAddAccountModelReponse extends ToAlipayModelResponse {

    /** 序列号 */
    private static final long serialVersionUID = 6194944745421293521L;
    /**
     * 绑定外部户协议号
     */
    private String            agreementId;

    /**
     * @param resultCode
     * @param resultMsg
     */
    public ToAlipayAddAccountModelReponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>agreementId</tt>.
     * 
     * @return property value of agreementId
     */
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * Setter method for property <tt>agreementId</tt>.
     * 
     * @param agreementId value to be assigned to property agreementId
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

}
