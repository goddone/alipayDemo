/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.process;

/**
 * 
 * 异常上下文
 * 
 * @author jie.hua@alipay.com
 * @version $Id: ExceptionContext.java, v 0.1 2014-1-9 上午2:23:13 jie.hua Exp $
 */
public class ExceptionContext {

    /**
     * 异常
     */
    private Exception exception;

    /**
     * @param exception
     */
    public ExceptionContext(Exception exception) {
        super();
        this.exception = exception;
    }

    /**
     * Getter method for property <tt>exception</tt>.
     * 
     * @return property value of exception
     */
    public Exception getException() {
        return exception;
    }

}
