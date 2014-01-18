/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 验证网关响应信息
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInVerifyInfo.java, v 0.1 2014-1-15 上午11:46:47 jie.hua Exp $
 */
public class AlipayInVerifyInfo extends ToStringBase {

    /** 序列号ID */
    private static final long serialVersionUID = -6455564869755124213L;

    /**
     * 业务信息，存放商户公钥
     */
    @XStreamAlias("biz_content")
    private String            bizContent;

    /**
     * 成功结果
     */
    @XStreamAlias("success")
    private boolean           success;

    /**
     * 错误码
     */
    @XStreamAlias("error_code")
    private String            errorCode;

    /**
     * Getter method for property <tt>success</tt>.
     * 
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     * 
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>bizContent</tt>.
     * 
     * @return property value of bizContent
     */
    public String getBizContent() {
        return bizContent;
    }

    /**
     * Setter method for property <tt>bizContent</tt>.
     * 
     * @param bizContent value to be assigned to property bizContent
     */
    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     * 
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     * 
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
