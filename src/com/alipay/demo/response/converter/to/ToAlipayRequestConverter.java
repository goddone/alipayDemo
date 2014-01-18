/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.response.converter.Converter;

/**
 * 商户->支付宝请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayRequestConverter.java, v 0.1 2014-1-11 下午3:07:03 jie.hua Exp $
 */
public abstract class ToAlipayRequestConverter
                                              implements
                                              Converter<ToAlipayModelRequest, ToAlipayTargetRequest> {

    /** 
     * @see com.alipay.demo.response.converter.Converter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {
        return ToAlipayModelRequest.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.Converter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayTargetRequest> getTargetClass() {
        return ToAlipayTargetRequest.class;
    }

}
