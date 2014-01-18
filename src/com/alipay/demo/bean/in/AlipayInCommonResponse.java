/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ResultEnum;

/**
 * 支付宝->商户通用业务应答
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInCommonResponse.java, v 0.1 2014-1-17 上午8:51:14 jie.hua Exp $
 */
public class AlipayInCommonResponse extends AlipayInModelResponse {

    /** 序列号 */
    private static final long   serialVersionUID = -5803973371003849075L;

    /**
     * 成功信息
     */
    private AlipayInSuccessInfo alipayInSuccessInfo;

    /**
     * 返回成功响应实例
     * 
     * @return
     */
    public static AlipayInCommonResponse getSuccessResponse() {

        return new AlipayInCommonResponse(ResultEnum.SUCESS.getResultCode(),
            ResultEnum.SUCESS.getResultMsg());
    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInCommonResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>alipayInSuccessInfo</tt>.
     * 
     * @return property value of alipayInSuccessInfo
     */
    public AlipayInSuccessInfo getAlipayInSuccessInfo() {
        return alipayInSuccessInfo;
    }

    /**
     * Setter method for property <tt>alipayInSuccessInfo</tt>.
     * 
     * @param alipayInSuccessInfo value to be assigned to property alipayInSuccessInfo
     */
    public void setAlipayInSuccessInfo(AlipayInSuccessInfo alipayInSuccessInfo) {
        this.alipayInSuccessInfo = alipayInSuccessInfo;
    }

}
