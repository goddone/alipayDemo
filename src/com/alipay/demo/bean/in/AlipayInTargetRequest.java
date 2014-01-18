/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import java.util.HashMap;
import java.util.Map;

/**
 * 原始请求参数
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInTargetRequest.java, v 0.1 2014-1-6 上午9:09:04 jie.hua Exp $
 */
public class AlipayInTargetRequest extends AlipayInParam {

    /** 序列号ID */
    private static final long   serialVersionUID = -7026732388040524936L;
    /**
     * 请求参数集合
     */
    private Map<String, String> requestParams    = new HashMap<String, String>();

    /**
     * @param requestParams
     */
    public AlipayInTargetRequest(Map<String, String> requestParams) {
        super();
        this.requestParams = requestParams;
    }

    /**
     * Getter method for property <tt>requestParams</tt>.
     * 
     * @return property value of requestParams
     */
    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    /**
     * Setter method for property <tt>requestParams</tt>.
     * 
     * @param requestParams value to be assigned to property requestParams
     */
    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }

}
