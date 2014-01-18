/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

import java.util.Date;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 向支付宝发送的消息类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayXMLMsg.java, v 0.1 2014-1-6 下午1:38:37 jie.hua Exp $
 */
@XStreamAlias("XML")
public class AlipayMsgBase extends ToStringBase {

    /** 序列号ID */
    private static final long serialVersionUID = 1766775190503432378L;

    /**
     * 公众号ID
     */
    @XStreamAlias("AppId")
    private String            appId;

    /**
     * 支付宝请求UID
     */
    @XStreamAlias("ToUserId")
    private String            toUserId;

    /**
     * 协议号
     */
    @XStreamAlias("AgreementId")
    private String            agreementId;

    /**
     * 发送时间
     */
    @XStreamAlias("CreateTime")
    private Date              createTime;

    /**
     * 消息类型
     */
    @XStreamAlias("MsgType")
    private String            msgType;

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
     * Getter method for property <tt>toUserId</tt>.
     * 
     * @return property value of toUserId
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * Setter method for property <tt>toUserId</tt>.
     * 
     * @param toUserId value to be assigned to property toUserId
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * Getter method for property <tt>agreementId</tt>.
     * 
     * @return property value of agreementId
     */
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * Setter method for property <tt>agreementId</tt>.
     * 
     * @param agreementId value to be assigned to property agreementId
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    /**
     * Getter method for property <tt>createTime</tt>.
     * 
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     * 
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter method for property <tt>msgType</tt>.
     * 
     * @return property value of msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Setter method for property <tt>msgType</tt>.
     * 
     * @param msgType value to be assigned to property msgType
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

}
