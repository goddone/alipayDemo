/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ResultSetter.java, v 0.1 2014-1-10 下午3:22:15 jie.hua Exp $
 */
public interface ResultSetter {

    /**
     * 设置成功标识
     * 
     * @param success 是否成功
     * @return
     */
    public void setSuccess(boolean success);

    /**
     * Setter method for property <tt>resultCode</tt>.
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode);

    /**
     * Setter method for property <tt>resultMsg</tt>.
     * 
     * @param resultMsg value to be assigned to property resultMsg
     */
    public void setResultMsg(String resultMsg);

}
