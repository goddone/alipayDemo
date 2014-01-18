/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayInVerifygwRespFactory;
import com.alipay.demo.bean.in.AlipayInVerifyInfo;
import com.alipay.demo.bean.in.AlipayInVerifygwResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * 支付宝->商户网关公钥验证执行器
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayVerifygwExecutor.java, v 0.1 2014-1-15 下午1:00:25 jie.hua Exp $
 */
public class InAlipayVerifygwExecutor extends InServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【支付宝请求商户网关验证】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",开始网关验证操作.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        AlipayInVerifygwResponse alipayInVerifygwResponse = AlipayInVerifygwResponse
            .getSuccessInstance();

        // 网关验证，返回商户公钥及成功标识
        AlipayInVerifyInfo alipayInVerifyInfo = new AlipayInVerifyInfo();
        alipayInVerifyInfo.setBizContent(SystemConfig.getMerchantPublicKey());
        alipayInVerifyInfo.setSuccess(true);

        // 组装网关验证业务应答
        alipayInVerifygwResponse.setAlipayInVerifyInfo(alipayInVerifyInfo);
        alipayInVerifygwResponse.setMerchantMsg(AlipayInVerifygwRespFactory
            .toArributeXML(alipayInVerifyInfo));

        inProcessContext.setAlipayInResponse(alipayInVerifygwResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",执行网关验证处理完毕.[alipayInVerifygwResponse="
                                + alipayInVerifygwResponse + "]");

    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {

        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.VERIFYGW_EVENT_TYPE, null);
    }

}
