/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;


/**
 * 支付宝请求商户的相应应答
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInModelResponse.java, v 0.1 2014-1-5 下午8:16:59 jie.hua Exp $
 */
public class AlipayInModelResponse extends AlipayInResponseParam {

    /** 序列号ID */
    private static final long serialVersionUID = -4932918722563320633L;

    /**
     * 响应应答的数据
     */
    private String            merchantMsg;

    /**
     * 构建一个失败的结果
     * 
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static AlipayInModelResponse buildFailResponse(String resultCode, String resultMsg) {

        AlipayInModelResponse alipayModelReponseParam = new AlipayInModelResponse(resultCode,
            resultMsg);
        alipayModelReponseParam.setSuccess(false);

        return alipayModelReponseParam;

    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayInModelResponse(String resultCode, String resultMsg) {
        super(resultCode, resultMsg);

    }

    /**
     * Getter method for property <tt>merchantMsg</tt>.
     * 
     * @return property value of merchantMsg
     */
    public String getMerchantMsg() {
        return merchantMsg;
    }

    /**
     * Setter method for property <tt>merchantMsg</tt>.
     * 
     * @param merchantMsg value to be assigned to property merchantMsg
     */
    public void setMerchantMsg(String merchantMsg) {
        this.merchantMsg = merchantMsg;
    }

}
