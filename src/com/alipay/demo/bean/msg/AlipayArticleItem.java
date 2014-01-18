/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

import com.alipay.demo.bean.ToStringBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 消息子项
 * @author jie.hua@alipay.com
 * @version $Id: AlipayXMLMsgArticleItem.java, v 0.1 2014-1-6 下午3:01:11 jie.hua Exp $
 */
@XStreamAlias("Item")
public class AlipayArticleItem extends ToStringBase {

    /** 序列号ID */
    private static final long serialVersionUID = 481652516767773271L;

    /**
     * 标题
     */
    @XStreamAlias("Title")
    private String            title;

    /**
     * 描述
     */
    @XStreamAlias("Desc")
    private String            desc;

    /**
     * 图片URL
     */
    @XStreamAlias("ImageUrl")
    private String            imageUrl;

    /**
     * 跳转URL
     */
    @XStreamAlias("Url")
    private String            url;

    /**
     * 操作名称
     */
    @XStreamAlias("ActionName")
    private String            actionName;

    /**
     * 授权类型
     */
    @XStreamAlias("AuthType")
    private String            authType;

    /**
     * Getter method for property <tt>title</tt>.
     * 
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     * 
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     * 
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     * 
     * @param desc value to be assigned to property desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>imageUrl</tt>.
     * 
     * @return property value of imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter method for property <tt>imageUrl</tt>.
     * 
     * @param imageUrl value to be assigned to property imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>actionName</tt>.
     * 
     * @return property value of actionName
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Setter method for property <tt>actionName</tt>.
     * 
     * @param actionName value to be assigned to property actionName
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * Getter method for property <tt>authType</tt>.
     * 
     * @return property value of authType
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Setter method for property <tt>authType</tt>.
     * 
     * @param authType value to be assigned to property authType
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

}
