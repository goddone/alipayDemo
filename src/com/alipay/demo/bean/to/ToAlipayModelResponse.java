/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

/**
 *  请求支付宝内部业务响应基类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayModelResponse.java, v 0.1 2014-1-10 下午2:49:39 jie.hua Exp $
 */
public class ToAlipayModelResponse extends ToAlipayResponseParam {

    /** 序列号ID */
    private static final long serialVersionUID = -2920927448694931553L;

    /**
     * @param resultBase
     */
    public ToAlipayModelResponse(String resultCode, String resultMsg) {

        super(resultCode, resultMsg);
    }

}
