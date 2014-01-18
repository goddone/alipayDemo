/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 向支付宝发送XML消息体
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayXMLMsg.java, v 0.1 2014-1-6 下午3:33:04 jie.hua Exp $
 */
@XStreamAlias("XML")
public class AlipayArticleMsg extends AlipayMsgBase {

    /** 序列号ID */
    private static final long         serialVersionUID = -3848958136465754732L;

    /**
     * 消息个数
     */
    @XStreamAlias("ArticleCount")
    private int                       articleCount;

    /**
     * 消息体内容
     */
    @XStreamAlias("Articles")
    private List<AlipayArticleItem> itemList         = new ArrayList<AlipayArticleItem>();

    /**
     * Getter method for property <tt>articleCount</tt>.
     * 
     * @return property value of articleCount
     */
    public int getArticleCount() {
        return articleCount;
    }

    /**
     * Getter method for property <tt>itemList</tt>.
     * 
     * @return property value of itemList
     */
    public List<AlipayArticleItem> getItemList() {
        return itemList;
    }

    /**
     * 添加项
     * 
     * @param item  
     */
    public void addItem(AlipayArticleItem item) {

        if (item != null) {
            this.itemList.add(item);
            this.articleCount = this.itemList.size();
        }

    }

    /**
     *  删除项
     * 
     * @param item  
     * @return
     */
    public boolean removeItem(AlipayArticleItem item) {

        boolean remove = this.itemList.remove(item);
        this.articleCount = this.itemList.size();

        return remove;
    }
}
