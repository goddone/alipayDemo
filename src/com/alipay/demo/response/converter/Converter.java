/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.response.converter;

/**
 * 模型转换接口
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Converter.java, v 0.1 2014-1-10 下午4:34:53 jie.hua Exp $
 */
public interface Converter<S, T> {

    /**
     * 将对象srcObj -> 目标obj
     * 
     * @param srcObj  原对象
     * @return  目标对象
     */
    public T convert(S srcObj);

    /**
     * 获取转换源class
     * 
     * @return
     */
    public Class<? extends S> getSrcClass();

    /**
     * 获取转换的目标class
     * 
     * @return
     */
    public Class<? extends T> getTargetClass();

}
