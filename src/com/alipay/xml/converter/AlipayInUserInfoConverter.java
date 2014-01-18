/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.xml.converter;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.alipay.demo.bean.in.AlipayInUserInfo;
import com.alipay.demo.tools.LoggerUtil;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 请求入参用户信息转换类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: UserInfoConverter.java, v 0.1 2014-1-6 上午10:56:41 jie.hua Exp $
 */
public class AlipayInUserInfoConverter implements Converter {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(AlipayInUserInfoConverter.class);

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#canConvert(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class type) {
        return type == AlipayInUserInfo.class;
    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        AlipayInUserInfo userInfo = (AlipayInUserInfo) source;

        writer.setValue(JSONObject.toJSONString(userInfo));

    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        try {
            return JSONObject.parseObject(reader.getValue(), AlipayInUserInfo.class);

        } catch (Exception e) {

            LoggerUtil.error(logger, "XML->Object 对象转换异常", e);
            return null;
        }

    }
}
