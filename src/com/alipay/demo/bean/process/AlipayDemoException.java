/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.process;

import com.alipay.demo.bean.ResultEnum;

/**
 * demo异常类
 * 
 * @author jie.hua@alipay.com
 * @version $Id: AlipayDemoException.java, v 0.1 2014-1-5 下午8:50:23 jie.hua Exp $
 */
public class AlipayDemoException extends RuntimeException {

    /** 序号号ID */
    private static final long serialVersionUID = -618616419812214433L;

    /**
     * 结果码
     */
    private String            resultCode;

    /**
     * 结果描述
     */
    private String            resultMsg;

    /**
     * 
     * @param throwAble
     * @param result
     */
    public AlipayDemoException(Throwable throwAble, ResultEnum result) {

        super(throwAble);
        build(result);
    }

    /**
     * @param resultCode
     * @param resultMsg
     */
    public AlipayDemoException(String resultCode, String resultMsg) {

        super();

        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 
     * @param resultEnum
     */
    public AlipayDemoException(ResultEnum resultEnum) {

        super();

        build(resultEnum);

    }

    /**
     * 
     * @param resultEnum
     */
    private void build(ResultEnum resultEnum) {
        if (resultEnum != null) {

            this.resultCode = resultEnum.getResultCode();
            this.resultMsg = resultEnum.getResultMsg();
        }
    }

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Getter method for property <tt>resultMsg</tt>.
     * 
     * @return property value of resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

}
