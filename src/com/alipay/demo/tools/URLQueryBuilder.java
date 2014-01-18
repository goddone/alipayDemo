/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * ULR查询串构造器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: URLQueryBuilder.java, v 0.1 2014-1-8 下午10:49:04 jie.hua Exp $
 */
public class URLQueryBuilder {

    /**
     * 日志管理
     */
    private static final Logger logger = Logger.getLogger(URLQueryBuilder.class);

    /**
     * 构造
     */
    private URLQueryBuilder() {
    }

    /**
     * 查询字符映射
     */
    private Map<String, String> queryMap = new HashMap<String, String>();

    /**
     * 构建一个实例
     * 
     * @return
     */
    public static URLQueryBuilder newBuilder() {

        return new URLQueryBuilder();
    }

    /**
     * 添加查询类
     * 
     * @param key
     * @param value
     * @return
     */
    public URLQueryBuilder appendQuery(String key, String value) {

        this.queryMap.put(key, value);

        return this;
    }

    /**
     * 转换成查询串
     * 
     * @return
     */
    public String toQueryString() {

        StringBuilder query = new StringBuilder(100);

        if (CollectionUtil.isNotEmpty(this.queryMap)) {

            for (Entry<String, String> entry : this.queryMap.entrySet()) {
                query.append(encode(entry.getKey(), "UTF-8"));
                query.append("=");
                query.append(encode(entry.getValue(), "UTF-8"));
                query.append("&");
            }
        }

        String queryStr = query.toString();
        //删除最后一个＆
        return StringUtils.left(queryStr, queryStr.length() - 1);

    }

    /**
     * 编码
     * 
     * @param value
     * @param charset
     * @return
     */
    private static String encode(String value, String charset) {

        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {

            LoggerUtil.error(logger, "参数编码转换异常", e);

            return null;
        }
    }

}
