/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import java.io.Serializable;

import com.alipay.demo.bean.ToStringBase;

/**
 * 绑定外部户信息
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAddAccountInfo.java, v 0.1 2014-1-10 上午10:06:02 jie.hua Exp $
 */
public class AlipayAddAccountInfo extends ToStringBase implements Serializable {

    /** 序列号ID */
    private static final long serialVersionUID = 3697014169147539263L;

    /**
     * 公众号ID
     */
    private String            appId;

    /**
     * 展示名称
     */
    private String            displayName;

    /**
     * 实际名称
     */
    private String            realName;

    /**
     * 绑定的外部账户ID
     */
    private String            bindAccountNo;

    /**
     * 申请绑定的支付宝UID
     */
    private String            fromUserId;

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Setter method for property <tt>appId</tt>.
     * 
     * @param appId value to be assigned to property appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Getter method for property <tt>displayName</tt>.
     * 
     * @return property value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Setter method for property <tt>displayName</tt>.
     * 
     * @param displayName value to be assigned to property displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Getter method for property <tt>realName</tt>.
     * 
     * @return property value of realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Setter method for property <tt>realName</tt>.
     * 
     * @param realName value to be assigned to property realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Getter method for property <tt>bindAccountNo</tt>.
     * 
     * @return property value of bindAccountNo
     */
    public String getBindAccountNo() {
        return bindAccountNo;
    }

    /**
     * Setter method for property <tt>bindAccountNo</tt>.
     * 
     * @param bindAccountNo value to be assigned to property bindAccountNo
     */
    public void setBindAccountNo(String bindAccountNo) {
        this.bindAccountNo = bindAccountNo;
    }

    /**
     * Getter method for property <tt>fromUserId</tt>.
     * 
     * @return property value of fromUserId
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * Setter method for property <tt>fromUserId</tt>.
     * 
     * @param fromUserId value to be assigned to property fromUserId
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

}
