/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.api.AlipayRequest;

/**
 * 直接与支付宝交互的请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetRequest.java, v 0.1 2014-1-10 下午12:54:25 jie.hua Exp $
 */
@SuppressWarnings("rawtypes")
public class ToAlipayTargetRequest extends ToAlipayParam {

    /** 序列号ID */
    private static final long serialVersionUID = 62846251755942039L;
    /**
     * 支付宝API请求
     */
    private AlipayRequest     alipayRequest;

    /**
     * @param alipayRequest
     */
    public ToAlipayTargetRequest(AlipayRequest alipayRequest) {
        super();
        this.alipayRequest = alipayRequest;
    }

    /**
     * Getter method for property <tt>alipayRequest</tt>.
     * 
     * @return property value of alipayRequest
     */
    public AlipayRequest getAlipayRequest() {
        return alipayRequest;
    }

}
