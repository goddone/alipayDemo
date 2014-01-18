/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.to;

import org.apache.log4j.Logger;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayAPIClientFactory;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.bean.to.ToAlipayModelRequest;
import com.alipay.demo.bean.to.ToAlipayTargetRequest;
import com.alipay.demo.bean.to.ToAlipayTargetResponse;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.tools.LoggerUtil;

/**
 *  请求支付宝API执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ToAlipayAPIExecutor.java, v 0.1 2014-1-11 下午4:44:44 jie.hua Exp $
 */
public abstract class ToAlipayAPIExecutor extends ToServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【请求支付宝API执行器】";

    /**
     * 日志操作
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void doAction(Instruction instruction) {

        ToProcessContext toProcessContext = instruction.getInstruction(ToProcessContext.class);

        ToAlipayTargetRequest toAlipayTargetRequest = toProcessContext
            .getInstruction(ToAlipayTargetRequest.class);
        ToAlipayModelRequest toModelRequest = toProcessContext
            .getInstruction(ToAlipayModelRequest.class);

        AlipayClient alipayClient = AlipayAPIClientFactory.getClientInstance();

        try {

            LoggerUtil.info(logger, OPERATION_NAME + ",开始请求支付宝网关：[modelRequest=" + toModelRequest
                                    + "]");

            // 调用支付宝API
            AlipayResponse alipayResponse = alipayClient.execute(toAlipayTargetRequest
                .getAlipayRequest());

            LoggerUtil.info(logger,
                OPERATION_NAME + ",请求支付宝网关完成：[targetResult=" + alipayResponse.getErrorCode()
                        + ",body=" + alipayResponse.getBody() + "]");

            ToAlipayTargetResponse toAlipayTargetResponse = new ToAlipayTargetResponse(
                alipayResponse);

            // 封装实际结果类
            toProcessContext.setToAlipayTargetResponse(toAlipayTargetResponse);

        } catch (AlipayApiException e) {

            LoggerUtil.error(logger, OPERATION_NAME + ",调用API异常.[apiName=" + getExecutorName()
                                     + "]", e);

            throw new AlipayDemoException(e, ResultEnum.ALIPAY_EXP_EXECUTOR);
        }

    }

}
