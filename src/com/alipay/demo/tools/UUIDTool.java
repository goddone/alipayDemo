/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.tools;

import java.util.UUID;

/**
 * UUDI工具类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: UUIDTool.java, v 0.1 2014-1-8 下午10:30:31 jie.hua Exp $
 */
public class UUIDTool {

    /**
     * 获取随机串
     * 
     * @return
     */
    public static String random() {

        return UUID.randomUUID().toString();
    }

}
