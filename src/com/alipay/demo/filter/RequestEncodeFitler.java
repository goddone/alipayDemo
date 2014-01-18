/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author jie.hua@alipay.com
 * @version $Id: RequestEncodeFitler.java, v 0.1 2014-1-5 下午7:21:17 jie.hua Exp $
 */
public class RequestEncodeFitler implements Filter {

    /**
     * 请求源编码
     */
    protected String requestSrcEncodeCode;

    /**
     * 请求编码
     */
    protected String requestEncodeCode;

    /**
     * 返回编码
     */
    protected String responseEncodeCode;

    /**
     * Default constructor.
     */
    public RequestEncodeFitler() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                                                             throws IOException,
                                                                                             ServletException {

        request.setCharacterEncoding(this.requestEncodeCode);
        response.setContentType("text/html;charset=" + this.responseEncodeCode);
        response.setCharacterEncoding(this.responseEncodeCode);

        chain.doFilter(new CharacterEncodingRequest((HttpServletRequest) request,
            requestSrcEncodeCode), response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {

        String requestEncodeCode = filterConfig.getInitParameter("requestEncodeCode");
        String responseEncodeCode = filterConfig.getInitParameter("responseEncodeCode");
        String requestSrcEncodeCode = filterConfig.getInitParameter("requestSrcEncodeCode");

        if (StringUtils.isNotBlank(requestEncodeCode)) {
            this.requestEncodeCode = requestEncodeCode;
        }

        if (StringUtils.isNotBlank(responseEncodeCode)) {
            this.responseEncodeCode = responseEncodeCode;
        }

        if (StringUtils.isNotBlank(requestSrcEncodeCode)) {
            this.requestSrcEncodeCode = requestSrcEncodeCode;
        }

    }

    /**
     * 对Get方式传递的请求参数进行编码
     */
    static class CharacterEncodingRequest extends HttpServletRequestWrapper {

        private HttpServletRequest request              = null;

        private String             requestSrcEncodeCode = null;

        public CharacterEncodingRequest(HttpServletRequest request, String requestSrcEncodeCode) {
            super(request);
            this.request = request;
            this.requestSrcEncodeCode = requestSrcEncodeCode;
        }

        /**
         * 对参数重新编码
         */
        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (value == null)
                return null;
            String method = request.getMethod();
            if ("get".equalsIgnoreCase(method) || "post".equalsIgnoreCase(method)) {
                try {

                    value = new String(value.getBytes(requestSrcEncodeCode),
                        request.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }

    }

}
