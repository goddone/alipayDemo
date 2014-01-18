/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.demo.config.SystemConfig;

/**
 * 
 * 支付宝API请求工厂类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014-1-10 下午1:52:21 jie.hua Exp $
 */
public class AlipayAPIClientFactory {

    /**
     * 子类holder类
     * 
     * @author jie.hua@alipay.com
     * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014-1-10 下午2:02:46 jie.hua Exp $
     */
    private static class AlipaySubHolder {

        /**
         * API执行器类
         */
        private static final AlipayClient ALIPAY_CLIENT = new DefaultAlipayClient(
                                                            SystemConfig.getGateWay(),
                                                            SystemConfig.getPublicId(),
                                                            SystemConfig.getMerchantPrivateKey());
    }

    /**
     * 获取唯一实例
     * 
     * @return
     */
    public static AlipayClient getClientInstance() {

        return AlipayAPIClientFactory.AlipaySubHolder.ALIPAY_CLIENT;
    }

}
