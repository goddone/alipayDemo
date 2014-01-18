/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

/**
 * 配置接口
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Config.java, v 0.1 2014-1-16 上午9:04:38 jie.hua Exp $
 */
public interface Config {

    /**
     * 获取网关地址
     * 
     * @return
     */
    public String getGateWay();

    /**
     * 获取公众号ID
     * 
     * @return
     */
    public String getPublicId();

    /**
     * 获取商户公钥
     * 
     * @return
     */
    public String getMerchantPublicKey();

    /**
     * 获取商户私钥
     * 
     * @return
     */
    public String getMerchantPrivateKey();

    /**
     * 支付宝公钥
     * 
     * @return
     */
    public String getAlipayPublicKey();

    /**
     * 是否对请求验签
     * 
     * @return
     */
    public boolean isCheckSign();

    /**
     * 是否对请求解密
     * 
     * @return
     */
    public boolean isDecrypt();

    /**
     * 是否对结果加签
     * 
     * @return
     */
    public boolean isSign();

    /**
     * 是否对结果加密
     * 
     * @return
     */
    public boolean isEncrypt();

}
