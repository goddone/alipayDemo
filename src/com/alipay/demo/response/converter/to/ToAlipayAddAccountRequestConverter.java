/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alibaba.fastjson.JSON;
import com.alipay.api.request.AlipayMobilePublicAccountAddRequest;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 商户->支付宝绑定账户请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAddAccountRequestConverter.java, v 0.1 2014-1-11 下午3:09:36 jie.hua Exp $
 */
public class ToAlipayAddAccountRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        ToAlipayAddAccountModelRequest addAccountModelRequest = (ToAlipayAddAccountModelRequest) srcObj;

        if (addAccountModelRequest != null) {

            // 1.转换成绑定账户的支付宝回调API请求
            AlipayMobilePublicAccountAddRequest addRequest = new AlipayMobilePublicAccountAddRequest();
            addRequest.setBizContent(JSON.toJSONString(addAccountModelRequest
                .getAlipayAddAccountInfo()));

            // 2.转换成目标请求
            return new ToAlipayTargetRequest(addRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {

        return ToAlipayAddAccountModelRequest.class;
    }

}
