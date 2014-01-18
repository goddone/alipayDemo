/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ResultEnum;

/**
 * 支付宝->商户网关验证应答
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInVerifygwResponse.java, v 0.1 2014-1-15 下午12:54:36 jie.hua Exp $
 */
public class AlipayInVerifygwResponse extends AlipayInModelResponse {

    /**  */
    private static final long  serialVersionUID = 2355253704601669150L;

    /**
     * 支付宝网关验证信息
     */
    private AlipayInVerifyInfo alipayInVerifyInfo;

    /**
     * 获取一个成功实例
     * 
     * @return
     */
    public static AlipayInVerifygwResponse getSuccessInstance() {

        AlipayInVerifygwResponse resp = new AlipayInVerifygwResponse(
            ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

        return resp;
    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInVerifygwResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
    }

    /**
     * Getter method for property <tt>alipayInVerifyInfo</tt>.
     * 
     * @return property value of alipayInVerifyInfo
     */
    public AlipayInVerifyInfo getAlipayInVerifyInfo() {
        return alipayInVerifyInfo;
    }

    /**
     * Setter method for property <tt>alipayInVerifyInfo</tt>.
     * 
     * @param alipayInVerifyInfo value to be assigned to property alipayInVerifyInfo
     */
    public void setAlipayInVerifyInfo(AlipayInVerifyInfo alipayInVerifyInfo) {
        this.alipayInVerifyInfo = alipayInVerifyInfo;
    }

}
