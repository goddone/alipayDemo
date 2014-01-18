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
 * ֧����->�̻���עִ֪ͨ����
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayFollowExecutor.java, v 0.1 2014-1-17 ����8:53:58 jie.hua Exp $
 */
public class InAlipayFollowExecutor extends InServiceExecutor {

    /**
     * ��������
     */
    private static final String OPERATION_NAME = "��֧������ע���ں�֪ͨ��";

    /**
     * ��־
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",��ʼִ�й�ע֪ͨ����.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        //TODO ����֧����������������Խ�֧�����˻�UID-���ں�ID��ϵ�־û������ں����̻��Լ�����������
        // ����ֻ�Ǹ��������������ⲽʡ�ԡ�
        // ֱ�ӹ������Ӧ�������
        AlipayInSuccessInfo alipayInSuccessInfo = new AlipayInSuccessInfo();
        alipayInSuccessInfo.setSuccess(true);

        AlipayInCommonResponse inCommonResponse = AlipayInCommonResponse.getSuccessResponse();
        inCommonResponse.setAlipayInSuccessInfo(alipayInSuccessInfo);
        inCommonResponse.setMerchantMsg(AlipayInCommonRespFactory
            .toArributeXML(alipayInSuccessInfo));

        inProcessContext.setAlipayInResponse(inCommonResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",ִ�й�ע֪ͨ�������.[inCommonResponse="
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