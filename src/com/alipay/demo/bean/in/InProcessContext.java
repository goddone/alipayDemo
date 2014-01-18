/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.in;

import com.alipay.demo.bean.process.BeanWire;
import com.alipay.demo.bean.process.ProcessContext;

/**
 * 支付宝请求->商户处理流程上下文
 * 
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InProcessContext.java, v 0.1 2014-1-5 下午8:14:01 jie.hua Exp $
 */
public class InProcessContext extends ProcessContext {

    /** 序列号ID */
    private static final long      serialVersionUID = -1153594338252638153L;

    /**
     * 支付宝->商户请求:当前业务请求
     */
    private AlipayInModelRequest   alipayInRequest;

    /**
     * 支付宝->商户请求的对应响应:当前业务响应
     */
    private AlipayInModelResponse  alipayInResponse;

    /**
     * 支付宝->商户原始请求
     */
    private AlipayInTargetRequest  alipayInTargetRequest;

    /**
     * 支付宝->商户请求的最终响应:最终对支付宝的响应
     */
    private AlipayInTargetResponse alipayInTargetResponse;

    /**
     * 获取一个实例
     * 
     * @return
     */
    public static InProcessContext getInstance() {

        return new InProcessContext();

    }

    /**
     * @param alipayInTargetRequest
     */
    public InProcessContext build(AlipayInTargetRequest alipayInTargetRequest) {

        this.setAlipayInTargetRequest(alipayInTargetRequest);

        return this;

    }

    /** 
     * @see com.alipay.demo.bean.process.Instruction#getInstruction(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BeanWire> T getInstruction(Class<T> t) {

        if (t == AlipayInModelRequest.class) {

            return (T) this.alipayInRequest;
        } else if (t == AlipayInModelResponse.class) {

            return (T) this.alipayInResponse;
        } else if (t == AlipayInTargetRequest.class) {

            return (T) this.alipayInTargetRequest;
        } else if (t == AlipayInTargetResponse.class) {

            return (T) this.alipayInTargetResponse;
        } else if (t == InProcessContext.class) {

            return (T) this;
        }

        return null;
    }

    /**
     * Setter method for property <tt>alipayInRequest</tt>.
     * 
     * @param alipayInRequest value to be assigned to property alipayInRequest
     */
    public void setAlipayInRequest(AlipayInModelRequest alipayInRequest) {
        this.alipayInRequest = alipayInRequest;
    }

    /**
     * Setter method for property <tt>alipayInResponse</tt>.
     * 
     * @param alipayInResponse value to be assigned to property alipayInResponse
     */
    public void setAlipayInResponse(AlipayInModelResponse alipayInResponse) {
        this.alipayInResponse = alipayInResponse;
    }

    /**
     * Setter method for property <tt>alipayInTargetRequest</tt>.
     * 
     * @param alipayInTargetRequest value to be assigned to property alipayInTargetRequest
     */
    public void setAlipayInTargetRequest(AlipayInTargetRequest alipayInTargetRequest) {
        this.alipayInTargetRequest = alipayInTargetRequest;
    }

    /**
     * Setter method for property <tt>alipayInTargetResponse</tt>.
     * 
     * @param alipayInTargetResponse value to be assigned to property alipayInTargetResponse
     */
    public void setAlipayInTargetResponse(AlipayInTargetResponse alipayInTargetResponse) {
        this.alipayInTargetResponse = alipayInTargetResponse;
    }

}
