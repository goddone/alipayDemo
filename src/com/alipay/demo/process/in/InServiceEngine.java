/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.bean.ResultEnum;
import com.alipay.demo.bean.factory.AlipayInModelReqFactory;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.AlipayInModelResponse;
import com.alipay.demo.bean.in.AlipayInTargetRequest;
import com.alipay.demo.bean.in.AlipayInTargetResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.process.AlipayDemoException;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngineTemplate;
import com.alipay.demo.process.ServiceExecutor;
import com.alipay.demo.tools.ServiceTool;

/**
 * 
 *  支付宝->商户请求服务处理引擎
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ServiceEngine.java, v 0.1 2014-1-5 下午8:41:47 jie.hua Exp $
 */
public class InServiceEngine extends ServiceEngineTemplate {

    /**
     * 请求服务工厂
     */
    private InServiceExecutorFactory inServiceExecutorFactory;

    /**
     * 执行前操作
     * 
     * @param instruction
     */
    @Override
    public void doBefore(Instruction instruction) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInTargetRequest inSrcRequest = inProcessContext
            .getInstruction(AlipayInTargetRequest.class);

        try {

            // 1.签名验签和解密
            String alipayMsg = AlipaySignature.checkSignAndDecrypt(inSrcRequest.getRequestParams(),
                SystemConfig.getAlipayPublicKey(), SystemConfig.getMerchantPrivateKey(),
                SystemConfig.isCheckSign(), SystemConfig.isEncrypt());

            // 2.请求转换
            AlipayInModelRequest alipayInRequest = AlipayInModelReqFactory.buildRequest(
                inSrcRequest.getRequestParams(), alipayMsg);

            inProcessContext.setAlipayInRequest(alipayInRequest);

        } catch (AlipayApiException e) {

            //TODO add log

            throw new AlipayDemoException(e, ResultEnum.SIGN_VERIFY_FAIL);
        }

    }

    /**
     * 服务处理
     * 
     * @param instruction
     */
    @Override
    public void doAction(Instruction instruction) {

        // 1.获取请求
        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        // 2.执行服务
        ServiceExecutor executor = inServiceExecutorFactory.getExecutorByName(ServiceTool
            .buildInServiceName(alipayInBizContent.getMsgType(), alipayInBizContent.getEventType(),
                alipayInBizContent.getActionParam()));

        // 3.执行服务
        // 3.1 没有对应服务，直接返回结果
        if (executor == null) {

            AlipayInModelResponse alipayInResponse = new AlipayInModelResponse(
                ResultEnum.SUCESS.getResultCode(), ResultEnum.SUCESS.getResultMsg());

            inProcessContext.setAlipayInResponse(alipayInResponse);

        } else {
            // 3.2 有则直接调用执行
            executor.doAction(instruction);
        }

    }

    /**
     *  执行完毕处理
     */
    @Override
    public void doFinal(Instruction instruction) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelResponse alipayInResponse = inProcessContext
            .getInstruction(AlipayInModelResponse.class);

        String merchantTargetMsg = null;
        String resultCode = alipayInResponse.getResultCode();
        String resultMsg = alipayInResponse.getResultMsg();

        try {

            //  1.对向支付宝返回的数据进行加签和加密
            merchantTargetMsg = AlipaySignature.encryptAndSign(alipayInResponse.getMerchantMsg(),
                SystemConfig.getAlipayPublicKey(), SystemConfig.getMerchantPrivateKey(),
                SystemConfig.getAlipayCharSet(), SystemConfig.isEncrypt(), SystemConfig.isSign());

        } catch (AlipayApiException e) {

            //TODO add log
            merchantTargetMsg = null;
            resultCode = ResultEnum.SIGN_DO_FAIL.getResultCode();
            resultMsg = ResultEnum.SIGN_DO_FAIL.getResultMsg();

        } finally {

            // 2.转换最终结果
            AlipayInTargetResponse alipayInTargetResponse = new AlipayInTargetResponse(resultCode,
                resultMsg);
            alipayInTargetResponse.setTargetMerchantMsg(merchantTargetMsg);

            inProcessContext.setAlipayInTargetResponse(alipayInTargetResponse);
        }

    }

    /**
     * 系统异常时处理
     * 
     * @param instruction
     * @param  e 
     */
    @Override
    public void doFail(Instruction instruction, Exception e) {

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);

        String resultCode = null;

        String resultMsg = null;

        if (e instanceof AlipayDemoException) {

            resultCode = ((AlipayDemoException) e).getResultCode();
            resultMsg = ((AlipayDemoException) e).getResultMsg();
        } else {

            resultCode = ResultEnum.SYSTEM_ERROR.getResultCode();
            resultMsg = ResultEnum.SYSTEM_ERROR.getResultMsg();
        }

        AlipayInModelResponse failResponse = AlipayInModelResponse.buildFailResponse(resultCode,
            resultMsg);
        // TODO 修改对应异常文案:这里可是写个工厂类，根据resultCode来回复对应结果
        failResponse.setMerchantMsg("出异常啦！！！");
        inProcessContext.setAlipayInResponse(failResponse);

    }

    /**
     * Setter method for property <tt>inServiceExecutorFactory</tt>.
     * 
     * @param inServiceExecutorFactory value to be assigned to property inServiceExecutorFactory
     */
    public void setInServiceExecutorFactory(InServiceExecutorFactory inServiceExecutorFactory) {
        this.inServiceExecutorFactory = inServiceExecutorFactory;
    }

}
