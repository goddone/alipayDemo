/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.demo.bean.HttpRequestKeys;
import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayCacheFactory;
import com.alipay.demo.bean.in.AlipayInUserInfo;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.to.AlipayAddAccountInfo;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelReponse;
import com.alipay.demo.bean.to.ToAlipayAddAccountModelRequest;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.URLTool;

/**
 * 绑定外部户请求地址
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayAuthenticationController.java, v 0.1 2014-1-6 下午11:25:29 jie.hua Exp $
 */
@Controller
public class AlipayAuthController {

    /**
     * 日志管理
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.WEB_LOGGER);

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【绑定账号Controller】";

    /**
     * 对外执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine       toServiceEngine;

    /**
     * 绑定外部户申请
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "applyAuth.do")
    public void doAuthApply(HttpServletRequest httpServletRequest, Model model) {

        // 1.获取缓存的用户信息
        String cacheId = httpServletRequest.getParameter(HttpRequestKeys.CACHE_KEY);
        Object cacheValue = AlipayCacheFactory.getCacheInstance().get(cacheId);

        LoggerUtil.info(logger, OPERATION_NAME + ",收到用户点击绑定链接。[cacheId=" + cacheId + ",cacheValue="
                                + cacheValue + ",queryStr=" + httpServletRequest.getQueryString()
                                + "]");

        // 2.用户信息输出
        if (cacheValue != null) {
            AlipayInUserInfo userInfo = (AlipayInUserInfo) cacheValue;
            model.addAttribute("userName", userInfo.getUser_name());
            model.addAttribute("loginId", userInfo.getLogon_id());
            model.addAttribute("userId", httpServletRequest.getParameter("userId"));

        }

    }

    /**
     * 绑定外部户表单提交
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "commitAuth.do")
    public ModelAndView doAuthCommit(HttpServletRequest httpServletRequest) {

        LoggerUtil.info(logger, OPERATION_NAME + ",用户确认提交绑定表单。");

        // 1.构建请求
        ToAlipayAddAccountModelRequest modelRequest = buildModelRequest(httpServletRequest);
        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(modelRequest);

        // 2.执行
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.根据结果输出对应页面
        ToAlipayModelResponse toAlipayModelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        ModelAndView modelAndView = new ModelAndView();

        if (!toAlipayModelResp.isSuccess()) {

            modelAndView.setViewName("authFail");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());

        } else {

            ToAlipayAddAccountModelReponse toAlipayAddAccountModelReponse = (ToAlipayAddAccountModelReponse) toAlipayModelResp;

            modelAndView.addObject("agreementId", toAlipayAddAccountModelReponse.getAgreementId());

            //绑定成功后同步发送一个发送成功消息
            ToAlipayModelResponse pushMsgResp = pushAddSuccessMsg(httpServletRequest,
                toAlipayAddAccountModelReponse.getAgreementId());
            modelAndView.addObject("pushMsg", pushMsgResp.isSuccess());

            modelAndView.setViewName("authSuccess");

        }
        return modelAndView;
    }

    /**
     * 发送添加账户成功消息
     * 
     * @param httpServletRequest
     * @param agreementId
     * @return 
     */
    private ToAlipayModelResponse pushAddSuccessMsg(HttpServletRequest httpServletRequest,
                                                    String agreementId) {

        LoggerUtil
            .info(logger, OPERATION_NAME + ",向用户对应账户发送绑定消息。[agreementId=" + agreementId + "]");

        //TODO 构建一个消息
        AlipayArticleMsg alipayArticleMsg = new AlipayArticleMsg();
        alipayArticleMsg.setAppId(SystemConfig.getPublicId());
        alipayArticleMsg.setCreateTime(new Date());
        alipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        alipayArticleMsg.setToUserId(httpServletRequest.getParameter("userId"));
        alipayArticleMsg.setAgreementId(agreementId);

        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("添加账户成功");
        item.setUrl(URLTool.builderURL(SystemConfig.getHostUrl() + "/msgDetail.do", null));

        alipayArticleMsg.addItem(item);

        // 1.构建请求
        ToAlipayMsgPushModelRequst toAlipayMsgPushModelRequst = ToAlipayMsgPushModelRequst
            .getInstance().build(alipayArticleMsg);

        ToProcessContext toProcessContext = ToProcessContext.getInstance().build(
            toAlipayMsgPushModelRequst);

        // 2.执行服务
        toServiceEngine.serviceProcess(toProcessContext);

        // 3.执行结果
        ToAlipayModelResponse toAlipayModelResp = toProcessContext
            .getInstruction(ToAlipayModelResponse.class);

        LoggerUtil.info(logger, OPERATION_NAME + ",向用户对应账户发送绑定消息完成。[agreementId=" + agreementId
                                + ",result=" + toAlipayModelResp.getResultCode() + "]");

        return toAlipayModelResp;
    }

    /**
     * 构建业务请求
     * 
     * @param httpServletRequest
     * @return
     */
    private ToAlipayAddAccountModelRequest buildModelRequest(HttpServletRequest httpServletRequest) {

        ToAlipayAddAccountModelRequest modelRequest = new ToAlipayAddAccountModelRequest();

        //TODO 添加实际用户信息，from db,file or anywhere
        AlipayAddAccountInfo accountInfo = new AlipayAddAccountInfo();
        accountInfo.setAppId(SystemConfig.getPublicId());
        accountInfo.setBindAccountNo("1111");
        accountInfo.setDisplayName("20141010");
        accountInfo.setRealName("少卿");
        accountInfo.setFromUserId(httpServletRequest.getParameter("userId"));

        modelRequest.setAlipayAddAccountInfo(accountInfo);

        return modelRequest;

    }
}
