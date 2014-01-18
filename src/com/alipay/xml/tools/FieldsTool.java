/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.xml.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类属性工具
 * 
 * @author jie.hua@alipay.com
 * @version $Id: FieldsTool.java, v 0.1 2014-1-15 下午12:38:16 jie.hua Exp $
 */
public class FieldsTool {

    /**
     * 获取对应所有属性(除了基本类型外)
     * 
     * @param source
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List<Field> getAllFieldsWithoutPrimitve(Object source) {

        List<Field> fields = new ArrayList<Field>();

        for (Class clz = source.getClass(); clz != Object.class && !isPrimitive(clz); clz = clz
            .getSuperclass()) {

            Field[] declaredFields = clz.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {

                fields.addAll(Arrays.asList(declaredFields));
            }

        }

        return fields;
    }

    /**
     * 获取对应所有属性
     * 
     * @param source
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List<Field> getAllFields(Object source) {

        List<Field> fields = new ArrayList<Field>();

        for (Class clz = source.getClass(); clz != Object.class; clz = clz.getSuperclass()) {

            Field[] declaredFields = clz.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {

                fields.addAll(Arrays.asList(declaredFields));
            }

        }

        return fields;
    }

    /**
     * 判断是否为基本类型
     * 
     * @param type
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isPrimitive(Class type) {
        return primitiveTypeFor(type) != null;
    }

    /**
     * 转换成基本类型
     * 
     * @param wrapper
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class primitiveTypeFor(Class wrapper) {

        if (wrapper == Boolean.class)
            return Boolean.TYPE;

        if (wrapper == Byte.class)
            return Byte.TYPE;

        if (wrapper == Character.class)
            return Character.TYPE;

        if (wrapper == Short.class)
            return Short.TYPE;

        if (wrapper == Integer.class)
            return Integer.TYPE;

        if (wrapper == Long.class)
            return Long.TYPE;

        if (wrapper == Float.class)
            return Float.TYPE;

        if (wrapper == Double.class)
            return Double.TYPE;

        if (wrapper == Void.class)
            return Void.TYPE;

        if (wrapper == String.class)
            return String.class;

        return null;
    }

}
