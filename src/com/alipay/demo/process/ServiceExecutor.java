/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * 服务执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceExecutor.java, v 0.1 2014-1-9 上午2:45:59 jie.hua Exp $
 */
public interface ServiceExecutor {

    /**
     * 执行操作
     * 
     * @param instruction
     */
    public void doAction(Instruction instruction);

}
