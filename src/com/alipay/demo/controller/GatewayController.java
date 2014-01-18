/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.demo.bean.factory.AlipayInTargetReqFactory;
import com.alipay.demo.bean.in.AlipayInTargetRequest;
import com.alipay.demo.bean.in.AlipayInTargetResponse;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.process.in.InServiceEngine;
import com.alipay.demo.tools.LoggerUtil;

/**
 * 商户服务网关controller类
 * <pre>
 *   作为当前服务器的统一入口网关地址
 * </pre>
 * @author jie.hua@alipay.com
 * @version $Id: GatewayController.java, v 0.1 2014-1-5 下午7:27:42 jie.hua Exp $
 */
@Controller
public class GatewayController {

    /**
     * 日志管理
     */
    private static final Logger logger         = Logger.getLogger("weblogger");

    /**
     * 请求参数
     */
    private static final String OPERATION_NAME = "【支付宝网关请求】";

    /**
     * 请求服务
     */
    @Autowired
    private InServiceEngine     inServiceEngine;

    /**
     * 统一入口网关url
     * 
     * @param request
     * @param repsonse
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "gateway/gateway.do")
    public void doProcess(HttpServletRequest request, HttpServletResponse repsonse)
                                                                                   throws Exception {

        LoggerUtil.info(logger, OPERATION_NAME + ",请求开始处理...");

        // 1.组装参数
        AlipayInTargetRequest alipayInSrcRequest = AlipayInTargetReqFactory.buildRequest(request);
        InProcessContext inProcessContext = InProcessContext.getInstance()
            .build(alipayInSrcRequest);

        LoggerUtil.info(logger, OPERATION_NAME + ",请求参数组装完成.[inProcessContext=" + inProcessContext
                                + "]");

        // 2.执行
        inServiceEngine.serviceProcess(inProcessContext);

        // 3.响应结果
        PrintWriter writer = repsonse.getWriter();

        AlipayInTargetResponse alipayInTargetResponse = inProcessContext
            .getInstruction(AlipayInTargetResponse.class);
        writer.println(alipayInTargetResponse.getTargetMerchantMsg());

        LoggerUtil
            .info(logger,
                OPERATION_NAME + ",请求处理完成.[应答结果：" + alipayInTargetResponse.getTargetMerchantMsg()
                        + "]");

    }

}
