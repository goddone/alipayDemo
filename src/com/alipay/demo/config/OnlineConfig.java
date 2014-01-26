/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.config;

import com.alipay.demo.bean.ToStringBase;

/**
 * 在线配置
 * 
 * @author jie.hua@alipay.com
 * @version $Id: OnlineConfig.java, v 0.1 2014-1-16 上午9:13:26 jie.hua Exp $
 */
public class OnlineConfig extends ToStringBase implements Config {

    /** 序列号 */
    private static final long serialVersionUID = 8372115145760188675L;

    /** 
     * @see com.alipay.demo.config.Config#getGateWay()
     */
    @Override
    public String getGateWay() {
        return "https://openapi.alipay.com/gateway.do";
    }

    /** 
     * @see com.alipay.demo.config.Config#getPublicId()
     */
    @Override
    public String getPublicId() {
        return "2014011400002593";
    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPublicKey()
     */
    @Override
    public String getMerchantPublicKey() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCitD16CypwZILTpdJL8nPV9rVFHYf5UWa/URNX6469mbQLpWfjKM/VSWRXsNVGSM3itOO/KG2Pw4x5g9xjH6iaE4LlaidjBIPpifISSlnpbyi4HxQTZYgMPv/TuiWofUN5kcwg/KQAQxB2OwTOeFu2i3LhqSCDmv6koTvHW15/hQIDAQAB";

    }

    /** 
     * @see com.alipay.demo.config.Config#getMerchantPrivateKey()
     */
    @Override
    public String getMerchantPrivateKey() {
        return "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKK0PXoLKnBkgtOl0kvyc9X2tUUdh/lRZr9RE1frjr2ZtAulZ+Moz9VJZFew1UZIzeK0478obY/DjHmD3GMfqJoTguVqJ2MEg+mJ8hJKWelvKLgfFBNliAw+/9O6Jah9Q3mRzCD8pABDEHY7BM54W7aLcuGpIIOa/qShO8dbXn+FAgMBAAECgYA8+nQ380taiDEIBZPFZv7G6AmT97doV3u8pDQttVjv8lUqMDm5RyhtdW4n91xXVR3ko4rfr9UwFkflmufUNp9HU9bHIVQS+HWLsPv9GypdTSNNp+nDn4JExUtAakJxZmGhCu/WjHIUzCoBCn6viernVC2L37NL1N4zrR73lSCk2QJBAPb/UOmtSx+PnA/mimqnFMMP3SX6cQmnynz9+63JlLjXD8rowRD2Z03U41Qfy+RED3yANZXCrE1V6vghYVmASYsCQQCoomZpeNxAKuUJZp+VaWi4WQeMW1KCK3aljaKLMZ57yb5Bsu+P3odyBk1AvYIPvdajAJiiikRdIDmi58dqfN0vAkEAjFX8LwjbCg+aaB5gvsA3t6ynxhBJcWb4UZQtD0zdRzhKLMuaBn05rKssjnuSaRuSgPaHe5OkOjx6yIiOuz98iQJAXIDpSMYhm5lsFiITPDScWzOLLnUR55HL/biaB1zqoODj2so7G2JoTiYiznamF9h9GuFC2TablbINq80U2NcxxQJBAMhw06Ha/U7qTjtAmr2qAuWSWvHU4ANu2h0RxYlKTpmWgO0f47jCOQhdC3T/RK7f38c7q8uPyi35eZ7S1e/PznY=";

    }

    /** 
     * @see com.alipay.demo.config.Config#getAlipayPublicKey()
     */
    @Override
    public String getAlipayPublicKey() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

    }

    /** 
     * @see com.alipay.demo.config.Config#isCheckSign()
     */
    @Override
    public boolean isCheckSign() {
        return true;
    }

    /** 
     * @see com.alipay.demo.config.Config#isDecrypt()
     */
    @Override
    public boolean isDecrypt() {
        return false;
    }

    /** 
     * @see com.alipay.demo.config.Config#isSign()
     */
    @Override
    public boolean isSign() {
        return true;
    }

    /** 
     * @see com.alipay.demo.config.Config#isEncrypt()
     */
    @Override
    public boolean isEncrypt() {
        return false;
    }

}
