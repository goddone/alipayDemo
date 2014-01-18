/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 消息详情Controller
 * @author jie.hua@alipay.com
 * @version $Id: AlipayMsgDetailController.java, v 0.1 2014-1-12 下午8:07:04 jie.hua Exp $
 */
@Controller
public class AlipayMsgDetailController {

    @RequestMapping("msgDetail.do")
    public void handlerDetail(HttpServletRequest httpServletRequest) {

    }

}
