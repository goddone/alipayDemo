/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter.to;

import com.alipay.api.request.AlipayMobilePublicMessagePushRequest;
import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;

/**
 * 
 * 发送消息提请求转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMsgPushRequestConverter.java, v 0.1 2014-1-12 下午4:18:11 jie.hua Exp $
 */
public class ToAlipayMsgPushRequestConverter extends ToAlipayRequestConverter {

    /** 
     * @see com.alipay.demo.response.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ToAlipayTargetRequest convert(ToAlipayModelRequest srcObj) {

        ToAlipayMsgPushModelRequst toAlipayMsgPushModelRequst = (ToAlipayMsgPushModelRequst) srcObj;

        if (toAlipayMsgPushModelRequst != null) {

            AlipayArticleMsg alipayArticleMsg = toAlipayMsgPushModelRequst.getAlipayArticleMsg();

            // 转换业务请求内容
            AlipayMobilePublicMessagePushRequest pushRequest = new AlipayMobilePublicMessagePushRequest();

            pushRequest.setBizContent(AlipayArticleMsgFactory.toXml(alipayArticleMsg));

            return new ToAlipayTargetRequest(pushRequest);

        }

        return null;
    }

    /** 
     * @see com.alipay.demo.response.converter.to.ToAlipayRequestConverter#getSrcClass()
     */
    @Override
    public Class<? extends ToAlipayModelRequest> getSrcClass() {

        return ToAlipayMsgPushModelRequst.class;
    }

}
