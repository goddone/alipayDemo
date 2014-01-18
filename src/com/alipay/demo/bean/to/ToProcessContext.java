/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.to;

import com.alipay.demo.bean.process.BeanWire;
import com.alipay.demo.bean.process.ProcessContext;

/**
 * 商户请求->支付宝商户处理上下文
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToProcessContext.java, v 0.1 2014-1-10 下午1:06:43 jie.hua Exp $
 */
public class ToProcessContext extends ProcessContext {

    /** 序列号ID */
    private static final long      serialVersionUID = -4855890717465632830L;

    /**
     * 支付宝API业务请求
     */
    private ToAlipayModelRequest   toAlipayModelRequest;

    /**
     * 支付宝API业务请求
     */
    private ToAlipayModelResponse  toAlipayModelReponse;

    /**
     * 支付宝API请求
     */
    private ToAlipayTargetRequest  toAlipayTargetRequest;

    /**
     * 支付宝API响应
     */
    private ToAlipayTargetResponse toAlipayTargetResponse;

    /**
     * 私有构造函数
     */
    private ToProcessContext() {
    }

    /**
     * 获取对外执行上下文实例
     * 
     * @return
     */
    public static ToProcessContext getInstance() {

        return new ToProcessContext();
    }

    /**
     * 构建实例
     * 
     * @param toAlipayModelRequest
     * @return
     */
    public ToProcessContext build(ToAlipayModelRequest toAlipayModelRequest) {

        this.setToAlipayModelRequest(toAlipayModelRequest);

        return this;
    }

    /** 
     * @see com.alipay.demo.bean.process.Instruction#getInstruction(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BeanWire> T getInstruction(Class<T> t) {

        if (t == ToAlipayModelRequest.class) {

            return (T) toAlipayModelRequest;
        } else if (t == ToAlipayTargetRequest.class) {

            return (T) toAlipayTargetRequest;
        } else if (t == ToAlipayTargetResponse.class) {

            return (T) toAlipayTargetResponse;
        } else if (t == ToAlipayModelResponse.class) {

            return (T) toAlipayModelReponse;
        } else if (t == ToProcessContext.class) {

            return (T) this;
        }

        return null;
    }

    /**
     * Setter method for property <tt>toAlipayModelRequest</tt>.
     * 
     * @param toAlipayModelRequest value to be assigned to property toAlipayModelRequest
     */
    public void setToAlipayModelRequest(ToAlipayModelRequest toAlipayModelRequest) {
        this.toAlipayModelRequest = toAlipayModelRequest;
    }

    /**
     * Setter method for property <tt>toAlipayTargetRequest</tt>.
     * 
     * @param toAlipayTargetRequest value to be assigned to property toAlipayTargetRequest
     */
    public void setToAlipayTargetRequest(ToAlipayTargetRequest toAlipayTargetRequest) {
        this.toAlipayTargetRequest = toAlipayTargetRequest;
    }

    /**
     * Setter method for property <tt>toAlipayTargetResponse</tt>.
     * 
     * @param toAlipayTargetResponse value to be assigned to property toAlipayTargetResponse
     */
    public void setToAlipayTargetResponse(ToAlipayTargetResponse toAlipayTargetResponse) {
        this.toAlipayTargetResponse = toAlipayTargetResponse;
    }

    /**
     * Setter method for property <tt>toAlipayModelReponse</tt>.
     * 
     * @param toAlipayModelReponse value to be assigned to property toAlipayModelReponse
     */
    public void setToAlipayModelReponse(ToAlipayModelResponse toAlipayModelReponse) {
        this.toAlipayModelReponse = toAlipayModelReponse;
    }

}
