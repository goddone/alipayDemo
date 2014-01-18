/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * 服务接口
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceExecute.java, v 0.1 2014-1-6 下午4:21:10 jie.hua Exp $
 */
public interface Service {

    /**
     * 执行前操作
     * 
     * @param instruction
     */
    public void doBefore(Instruction instruction);

    /**
     * 服务处理
     * 
     * @param instruction
     */
    public void doAction(Instruction instruction);

    /**
     *  执行完毕处理
     */
    public void doFinal(Instruction instruction);

    /**
     * 系统异常时处理
     * 
     * @param instruction
     * @param  e 
     */
    public void doFail(Instruction instruction, Exception e);

}
