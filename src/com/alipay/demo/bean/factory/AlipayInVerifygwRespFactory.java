/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import com.alipay.xml.AdvanceXStream;

/**
 * 网关验证响应工厂类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInVerifygwRespFactory.java, v 0.1 2014-1-15 下午1:15:12 jie.hua Exp $
 */
public class AlipayInVerifygwRespFactory {

    /**
     * xml解析器
     */
    private static AdvanceXStream advanceXStream = new AdvanceXStream();

    /**
     * 属性转换成xml
     * 
     * @param obj
     * @return
     */
    public static String toArributeXML(Object obj) {

        return advanceXStream.toArributeXML(obj);

    }

}
