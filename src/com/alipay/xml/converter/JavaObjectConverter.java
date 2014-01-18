/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.xml.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.alipay.xml.tools.FieldsTool;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 类型转换器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: JavaObjectConverter.java, v 0.1 2014-1-6 上午9:47:42 jie.hua Exp $
 */
public class JavaObjectConverter implements Converter {

    private Logger logger = Logger.getLogger(JavaObjectConverter.class.toString());

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#canConvert(java.lang.Class)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean canConvert(Class type) {

        Annotation annotation = type.getAnnotation(XStreamAlias.class);

        return annotation != null;
    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        List<Field> declaredFields = FieldsTool.getAllFieldsWithoutPrimitve(source);

        if (declaredFields == null || declaredFields.size() <= 0) {

            return;
        }

        for (Field field : declaredFields) {

            XStreamAlias annotation = field.getAnnotation(XStreamAlias.class);

            if (annotation != null && StringUtils.isNotBlank(annotation.value())) {

                try {
                    field.setAccessible(true);
                    writer.startNode(annotation.value());
                    Object object = field.get(source);

                    if (object == null) {
                        continue;
                    }

                    context.convertAnother(object);
                } catch (Exception e) {

                    logger.log(Level.WARNING, "解析xml异常", e);
                } finally {

                    writer.endNode();
                }

            }

        }

    }

    /** 
     * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
     */
    @SuppressWarnings("rawtypes")
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Class requiredType = context.getRequiredType();

        try {
            Object newInstance = requiredType.newInstance();
            List<Field> declaredFields = FieldsTool.getAllFieldsWithoutPrimitve(newInstance);
            Map<String, Field> annotationMap = new HashMap<String, Field>();
            for (Field field : declaredFields) {
                XStreamAlias annotation = field.getAnnotation(XStreamAlias.class);

                if (annotation != null && StringUtils.isNotBlank(annotation.value())) {
                    annotationMap.put(annotation.value(), field);
                }

            }

            while (reader.hasMoreChildren()) {

                reader.moveDown();

                Field targetField = annotationMap.get(reader.getNodeName());
                if (targetField == null) {

                    reader.moveUp();
                    continue;
                }
                Object targetFieldValue = context
                    .convertAnother(newInstance, targetField.getType());

                targetField.setAccessible(true);
                targetField.set(newInstance, targetFieldValue);

                reader.moveUp();
            }

            return newInstance;

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.FINER, "xml->bean 解析xml异常", e);
        }

        return null;
    }

}
