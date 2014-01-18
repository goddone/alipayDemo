/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.process;


/**
 * 参数获取接口
 * 
 * @author jie.hua@alipay.com
 * @version $Id: Instruction.java, v 0.1 2014-1-5 下午7:57:20 jie.hua Exp $
 */
public interface Instruction {

    /**
     * 根据传入参数类型，转换成对应的参数
     * 
     * @param t
     * @return
     */
    public <T extends BeanWire> T getInstruction(Class<T> t);

}
