/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process;

import com.alipay.demo.bean.process.Instruction;


/**
 * 服务执行接口
 * @author jie.hua@alipay.com
 * @version $Id: ServiceEngine.java, v 0.1 2014-1-6 下午4:33:12 jie.hua Exp $
 */
public interface ServiceEngine {

    /**
     * 模板服务，统一处理请求
     * 
     * @param instruction
     */
    public void serviceProcess(Instruction instruction);

}
