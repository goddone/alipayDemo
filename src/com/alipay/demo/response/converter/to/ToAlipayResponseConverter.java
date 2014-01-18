/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.AlipayResponse;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.response.converter.Converter;

/**
 * 业务响应转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayResponseConverter.java, v 0.1 2014-1-10 下午4:38:10 jie.hua Exp $
 */
public abstract class ToAlipayResponseConverter implements
                                               Converter<AlipayResponse, ToAlipayModelResponse> {

    /** 
     * @see com.alipay.demo.response.converter.Converter#getSrcClass()
     */
    @Override
    public Class<? extends AlipayResponse> getSrcClass() {
        return AlipayResponse.class;
    }

    /** 
     * @see com.alipay.demo.response.converter.Converter#getTargetClass()
     */
    @Override
    public Class<? extends ToAlipayModelResponse> getTargetClass() {
        return ToAlipayModelResponse.class;
    }

}
