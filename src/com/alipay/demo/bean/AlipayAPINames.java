/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 
 * 支付宝与商户之间交互的所有API名称
 * <pre>
 *   使用支付宝SDK，已经无需关系支付宝相关的API名称了，
 *   只需要直接调用SDK内部对应的请求Bean即可
 * </pre>
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAPINames.java, v 0.1 2014-1-10 上午9:09:57 jie.hua Exp $
 */
public class AlipayAPINames {

    /**
     * 支付宝请求商户的统一API
     */
    public static final String ALIPAY_TO_MERCHANT_API = "alipay.mobile.public.message.notify";

    /**
     * 支付宝账户绑定回调API
     */
    public static final String ALIPAY_ADD_ACCOUNT_API = "alipay.mobile.public.account.add";

    /**
     * 支付宝推送用户消息API
     */
    public static final String ALIPAY_MSG_PUSH_API    = "alipay.mobile.public.message.push";

}
