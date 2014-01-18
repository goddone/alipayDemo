/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean;

/**
 * 结果接口
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Result.java, v 0.1 2014-1-8 下午8:15:30 jie.hua Exp $
 */
public interface Result {

    /**
     * 结果是否成功
     * 
     * @return
     */
    public boolean isSuccess();

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode();

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg();

}
