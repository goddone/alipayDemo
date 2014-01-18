/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayInCommonRespFactory;
import com.alipay.demo.bean.in.AlipayInCommonResponse;
import com.alipay.demo.bean.in.AlipayInSuccessInfo;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * 支付宝->商户关注通知执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayFollowExecutor.java, v 0.1 2014-1-17 上午8:53:58 jie.hua Exp $
 */
public class InAlipayFollowExecutor extends InServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【支付宝关注公众号通知】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",开始执行关注通知操作.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        //TODO 根据支付宝请求参数，可以将支付宝账户UID-公众号ID关系持久化，用于后续商户自己的其他操作
        // 这里只是个样例程序，所以这步省略。
        // 直接构造简单响应结果返回
        AlipayInSuccessInfo alipayInSuccessInfo = new AlipayInSuccessInfo();
        alipayInSuccessInfo.setSuccess(true);

        AlipayInCommonResponse inCommonResponse = AlipayInCommonResponse.getSuccessResponse();
        inCommonResponse.setAlipayInSuccessInfo(alipayInSuccessInfo);
        inCommonResponse.setMerchantMsg(AlipayInCommonRespFactory
            .toArributeXML(alipayInSuccessInfo));

        inProcessContext.setAlipayInResponse(inCommonResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",执行关注通知处理完毕.[inCommonResponse="
                                + inCommonResponse + "]");

    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.FOLLOW_EVENT_TYPE, null);
    }

}
