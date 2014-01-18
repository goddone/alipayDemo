/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.AlipayAPINames;
import com.alipay.demo.bean.msg.AlipayArticleMsg;

/**
 *  商户->支付宝推送用户消息业务请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayMsgPushModelRequst.java, v 0.1 2014-1-12 下午4:04:48 jie.hua Exp $
 */
public class ToAlipayMsgPushModelRequst extends ToAlipayModelRequest {

    /** 序列号ID */
    private static final long serialVersionUID = -502923808214645858L;

    /**
     * 推送消息体
     */
    private AlipayArticleMsg  alipayArticleMsg;

    /**
     * 私有构造器
     */
    private ToAlipayMsgPushModelRequst() {
    }

    /**
     * 构造器
     * 
     * @param alipayArticleMsg
     * @return
     */
    public ToAlipayMsgPushModelRequst build(AlipayArticleMsg alipayArticleMsg) {

        this.setAlipayArticleMsg(alipayArticleMsg);

        return this;
    }

    /**
     * 获取一个实例
     * 
     * @return
     */
    public static ToAlipayMsgPushModelRequst getInstance() {

        return new ToAlipayMsgPushModelRequst();
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return AlipayAPINames.ALIPAY_MSG_PUSH_API;
    }

    /**
     * Getter method for property <tt>alipayArticleMsg</tt>.
     * 
     * @return property value of alipayArticleMsg
     */
    public AlipayArticleMsg getAlipayArticleMsg() {
        return alipayArticleMsg;
    }

    /**
     * Setter method for property <tt>alipayArticleMsg</tt>.
     * 
     * @param alipayArticleMsg value to be assigned to property alipayArticleMsg
     */
    public void setAlipayArticleMsg(AlipayArticleMsg alipayArticleMsg) {
        this.alipayArticleMsg = alipayArticleMsg;
    }

}
