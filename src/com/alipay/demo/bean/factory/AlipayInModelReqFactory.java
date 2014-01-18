/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.factory;

import java.util.Map;

import com.alipay.demo.bean.AlipayAPIKeys;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.AlipayInUserInfo;
import com.alipay.xml.AdvanceXStream;
import com.alipay.xml.converter.AlipayInUserInfoConverter;
import com.alipay.xml.converter.DateLongFormatConverter;
import com.alipay.xml.converter.JavaObjectConverter;

/**
 * 支付宝->商户请求工厂类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayInModelReqFactory.java, v 0.1 2014-1-5 下午8:20:15 jie.hua Exp $
 */
public class AlipayInModelReqFactory {

    /**
     * xml解析器
     */
    private static AdvanceXStream advanceXStream = new AdvanceXStream();

    static {

        advanceXStream.registerConverter(new JavaObjectConverter());
        advanceXStream.registerConverter(new DateLongFormatConverter());
        advanceXStream.registerConverter(new AlipayInUserInfoConverter());

        advanceXStream.registerParserClass(AlipayInBizContent.class, AlipayInUserInfo.class);
    }

    /**
     *  请求参数->AlipayInModelRequest
     * 
     * @param requestParams
     * @param alipayMsg
     * @return
     */
    public static AlipayInModelRequest buildRequest(Map<String, String> requestParams, String alipayMsg) {

        AlipayInModelRequest alipayInRequest = new AlipayInModelRequest();

        alipayInRequest.setBizContent(alipayMsg);

        alipayInRequest.setCharset(requestParams.get(AlipayAPIKeys.CHARSET));

        alipayInRequest.setService(requestParams.get(AlipayAPIKeys.SERVICE));

        alipayInRequest.setSign(requestParams.get(AlipayAPIKeys.SIGN));

        alipayInRequest.setSignType(requestParams.get(AlipayAPIKeys.SIGN_TYPE));

        AlipayInBizContent alipayInBizContent = (AlipayInBizContent) advanceXStream
            .fromXml(alipayMsg);

        alipayInRequest.setAlipayInBizContent(alipayInBizContent);

        return alipayInRequest;
    }

}
