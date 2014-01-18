/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.bean.msg;

/**
 * 消息相关常量
 * 
 * @author jie.hua@alipay.com
 * @version $Id: MsgConstants.java, v 0.1 2014-1-6 下午4:40:41 jie.hua Exp $
 */
public class MsgConstants {

    /**
     * 事件型消息
     */
    public static final String EVENT_MSG_TYPE              = "event";

    /**
     * 事件点击
     */
    public static final String CLICK_EVENT_TYPE            = "click";

    /**
     * 验证网关
     */
    public static final String VERIFYGW_EVENT_TYPE         = "verifygw";

    /**
     * 关注
     */
    public static final String FOLLOW_EVENT_TYPE           = "follow";

    /**
     * 取消关注
     */
    public static final String UNFOLLOW_EVENT_TYPE         = "unfollow";

    /**
     * 绑定外部户参数
     */
    public static final String AUTHENTICATION_ACTIONPARAMS = "authentication";

    /**
     * 删除外部户参数
     */
    public static final String DELETE_BIND_ACTIONPARAMS    = "delete";

    /**
     * 图文消息类型
     */
    public static final String IMGTXT_MSG_TYPE             = "image-text";

    /**
     * 菜单key常量
     * 
     * @author jie.hua@alipay.com
     * @version $Id: MsgConstants.java, v 0.1 2014-1-17 上午9:11:03 jie.hua Exp $
     */
    public static class MenuKeys {

        /**
         * 消息应答式菜单key
         */
        public static final String MENU_MSG_RESP = "MSG_RESP";

    }

}
