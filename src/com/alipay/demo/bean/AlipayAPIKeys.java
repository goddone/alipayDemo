/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 支付宝所有交互服务的key值
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInRequestKeys.java, v 0.1 2014-1-5 下午8:25:09 jie.hua Exp $
 */
public final class AlipayAPIKeys {

    /**
     * 服务api key
     */
    public final static String SERVICE   = "service";

    /**
     * 签名数据
     */
    public final static String SIGN      = "sign";

    /**
     * 签名类型
     */
    public final static String SIGN_TYPE = "sign_type";

    /**
     * 字符集
     */
    public final static String CHARSET   = "charset";

    /**
     * 支付宝->商户请求独有key
     * 
     * @author jie.hua@alipay.com
     * @version $Id: AlipayAPIKeys.java, v 0.1 2014-1-5 下午8:29:39 jie.hua Exp $
     */
    public static class AlipayInServiceKeys {

        /**
         * 业务参数
         */
        public final static String BIZ_CONTENT = "biz_content";
    }

}
