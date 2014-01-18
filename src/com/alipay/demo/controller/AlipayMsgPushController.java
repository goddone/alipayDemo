/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.to.ToAlipayModelResponse;
import com.alipay.demo.bean.to.ToAlipayMsgPushModelRequst;
import com.alipay.demo.bean.to.ToProcessContext;
import com.alipay.demo.config.SystemConfig;
import com.alipay.demo.process.ServiceEngine;
import com.alipay.demo.tools.URLTool;

/**
 * 消息发送控制器
 * <pre>
 *   这里只是个样例，真实情况下的消息发送应该是有其他业务触发的，例如银行卡动账、手机话费提醒等
 *   只需要参照本controller内handlerPush即可
 * </pre>
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMsgPushController.java, v 0.1 2014-1-12 下午4:40:31 jie.hua Exp $
 */
@Controller
public class AlipayMsgPushController {

    /**
     * 商户->支付宝服务执行引擎
     */
    @Autowired
    @Qualifier("toServiceEngine")
    private ServiceEngine toServiceEngine;

    /**
     * 展示消息输入界面
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.GET, value = "msginput.do")
    public void handlerInput(HttpServletRequest httpServletRequest) {

    }

    /**
     * 提交发送消息
     * 
     * @param httpServletRequest
     */
    @RequestMapping(method = RequestMethod.POST, value = "push.do")
    public ModelAndView handlerPush(HttpServletRequest httpServletRequest) {

        //TODO 构建一个消息
        AlipayArticleMsg alipayArticleMsg = new AlipayArticleMsg();
        alipayArticleMsg.setAppId(SystemConfig.getPublicId());
        alipayArticleMsg.setCreateTime(new Date());
        alipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);

        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("测试消息推送");
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

        ModelAndView modelAndView = new ModelAndView();

        if (toAlipayModelResp.isSuccess()) {
            modelAndView.setViewName("msgPushSuccess");
        } else {
            modelAndView.setViewName("msgPushFail");
            modelAndView.addObject("errorMsg", toAlipayModelResp.getResultMsg());
            modelAndView.addObject("errorCode", toAlipayModelResp.getResultCode());
        }

        return modelAndView;

    }
}
