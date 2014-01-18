/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import com.alipay.demo.bean.AlipayAPINames;

/**
 * 商户->支付宝绑定外部户回调执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAddAccountExecutor.java, v 0.1 2014-1-11 下午2:43:24 jie.hua Exp $
 */
public class ToAlipayAddAccountExecutor extends ToAlipayAPIExecutor {

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return AlipayAPINames.ALIPAY_ADD_ACCOUNT_API;
    }

}
