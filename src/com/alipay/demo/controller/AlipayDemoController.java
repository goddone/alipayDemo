/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  just a demo controller
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayDemoController.java, v 0.1 2014-1-5 обнГ7:16:57 jie.hua Exp $
 */
@Controller
public class AlipayDemoController {

    @RequestMapping(value = "demogate.do")
    public void doProcess(HttpServletRequest req, Model model) {

    }

}
