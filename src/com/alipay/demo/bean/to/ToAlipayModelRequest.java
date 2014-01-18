/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.process.ServiceExecutorNameWire;

/**
 * 向支付宝发起调用的原始请求
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayModelRequest.java, v 0.1 2014-1-10 上午9:49:46 jie.hua Exp $
 */
public abstract class ToAlipayModelRequest extends ToAlipayParam implements ServiceExecutorNameWire {

    /**  序列号ID */
    private static final long serialVersionUID = 7380070532157388017L;

}
