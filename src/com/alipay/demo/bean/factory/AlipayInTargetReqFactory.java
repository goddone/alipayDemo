/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alipay.demo.bean.in.AlipayInTargetRequest;

/**
 * 原始请求参数工厂类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInTargetReqFactory.java, v 0.1 2014-1-6 上午9:10:56 jie.hua Exp $
 */
public class AlipayInTargetReqFactory {

    /**
     *  httpServletRequest -> AlipayInTargetRequest
     * 
     * @param httpServletRequest  httpservlet请求
     * @return
     */
    public static AlipayInTargetRequest buildRequest(HttpServletRequest httpServletRequest) {

        Map<String, String> params = new HashMap<String, String>();
        for (Object key : httpServletRequest.getParameterMap().keySet()) {
            String keyStr = (String) key;
            params.put(keyStr, httpServletRequest.getParameter(keyStr));
        }

        return new AlipayInTargetRequest(params);

    }

}
