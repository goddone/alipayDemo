/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.AlipayInModelResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * 支付宝->商户删除账户绑定执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayDeleteBindExecutor.java, v 0.1 2014-1-13 下午9:11:26 jie.hua Exp $
 */
public class InAlipayDeleteBindExecutor extends InServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【支付宝删除绑定账户通知处理】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",开始执行删除绑定处理.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        //TODO 这里只是简单demo直接返回成功，实际需要删除商户本地绑定关系
        AlipayInModelResponse alipayInModelResponse = new AlipayInModelResponse(
            ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

        inProcessContext.setAlipayInResponse(alipayInModelResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",执行删除绑定处理完毕.[alipayInBizContent="
                                + alipayInBizContent + "]");
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.DELETE_BIND_ACTIONPARAMS);
    }

}
