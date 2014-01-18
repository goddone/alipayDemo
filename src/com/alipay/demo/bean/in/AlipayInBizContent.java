/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import java.util.Date;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 请求业务数据
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInBizContent.java, v 0.1 2014-1-6 上午9:57:12 jie.hua Exp $
 */
@XStreamAlias("XML")
public class AlipayInBizContent extends ToStringBase {

    /** 序列号ID */
    private static final long serialVersionUID = 7078380557587046793L;

    /**
     * 公众号ID
     */
    @XStreamAlias("AppId")
    private String            appId;

    /**
     * 支付宝请求UID
     */
    @XStreamAlias("FromUserId")
    private String            fromUserId;

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
     * 事件类型
     */
    @XStreamAlias("EventType")
    private String            eventType;

    /**
     * 事件内容
     */
    @XStreamAlias("ActionParam")
    private String            actionParam;

    /**
     * 用户相关信息
     */
    @XStreamAlias("UserInfo")
    private AlipayInUserInfo  userInfo;

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

    /**
     * Getter method for property <tt>eventType</tt>.
     * 
     * @return property value of eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Setter method for property <tt>eventType</tt>.
     * 
     * @param eventType value to be assigned to property eventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Getter method for property <tt>actionParam</tt>.
     * 
     * @return property value of actionParam
     */
    public String getActionParam() {
        return actionParam;
    }

    /**
     * Setter method for property <tt>actionParam</tt>.
     * 
     * @param actionParam value to be assigned to property actionParam
     */
    public void setActionParam(String actionParam) {
        this.actionParam = actionParam;
    }

    /**
     * Getter method for property <tt>userInfo</tt>.
     * 
     * @return property value of userInfo
     */
    public AlipayInUserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Setter method for property <tt>userInfo</tt>.
     * 
     * @param userInfo value to be assigned to property userInfo
     */
    public void setUserInfo(AlipayInUserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
