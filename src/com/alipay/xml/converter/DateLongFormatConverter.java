/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.xml.converter;

import java.util.Date;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * date转换成毫秒数 转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: DateLongFormatConverter.java, v 0.1 2014-1-6 上午9:52:56 jie.hua Exp $
 */
public class DateLongFormatConverter implements Converter {

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#canConvert(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class type) {
        return type == Date.class;
    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        Date date = (Date) source;

        writer.setValue(date.getTime() + "");

    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        return new Date(Long.valueOf(reader.getValue()));
    }

}
