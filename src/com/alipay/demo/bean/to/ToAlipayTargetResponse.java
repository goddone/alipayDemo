/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.api.AlipayResponse;

/**
 * 直接与支付宝交互的实际响应
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayTargetResponse.java, v 0.1 2014-1-10 下午1:02:57 jie.hua Exp $
 */
public class ToAlipayTargetResponse extends ToAlipayParam {

    /** 序列号ID  */
    private static final long serialVersionUID = 6355237518119428759L;

    /**
     * 支付宝API响应
     */
    private AlipayResponse    alipayResponse;

    /**
     * @param alipayResponse
     */
    public ToAlipayTargetResponse(AlipayResponse alipayResponse) {
        super();
        this.alipayResponse = alipayResponse;
    }

    /**
     * Getter method for property <tt>alipayResponse</tt>.
     * 
     * @return property value of alipayResponse
     */
    public AlipayResponse getAlipayResponse() {
        return alipayResponse;
    }

}
