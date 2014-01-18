/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.alipay.demo.process.in;

import java.util.Date;

import org.apache.log4j.Logger;

import com.alipay.demo.bean.LoggerNames;
import com.alipay.demo.bean.factory.AlipayArticleMsgFactory;
import com.alipay.demo.bean.in.AlipayInArticleMsgResponse;
import com.alipay.demo.bean.in.AlipayInBizContent;
import com.alipay.demo.bean.in.AlipayInModelRequest;
import com.alipay.demo.bean.in.InProcessContext;
import com.alipay.demo.bean.msg.AlipayArticleItem;
import com.alipay.demo.bean.msg.AlipayArticleMsg;
import com.alipay.demo.bean.msg.MsgConstants;
import com.alipay.demo.bean.process.Instruction;
import com.alipay.demo.tools.LoggerUtil;
import com.alipay.demo.tools.ServiceTool;

/**
 * 支付宝->商户菜单请求
 * <pre>
 *   这只是一种菜单响应的执行样例，商户可以配置不同的菜单，相应根据不同的菜单key
 *   需要不同的执行器来对应执行
 * </pre>
 * 
 * @author jie.hua@alipay.com
 * @version $Id: InAlipayMenuMsgExecutor.java, v 0.1 2014-1-17 上午9:12:50 jie.hua Exp $
 */
public class InAlipayMenuMsgExecutor extends InServiceExecutor {

    /**
     * 操作名称
     */
    private static final String OPERATION_NAME = "【支付宝点击菜单请求】";

    /**
     * 日志
     */
    private static final Logger logger         = Logger.getLogger(LoggerNames.SERVICE_LOGGER);

    /** 
     * @see com.alipay.demo.process.ServiceExecutor#doAction(com.alipay.demo.bean.process.Instruction)
     */
    @Override
    public void doAction(Instruction instruction) {

        LoggerUtil.info(logger, OPERATION_NAME + ",开始执行菜单点击处理.");

        InProcessContext inProcessContext = instruction.getInstruction(InProcessContext.class);
        AlipayInModelRequest alipayInRequest = inProcessContext
            .getInstruction(AlipayInModelRequest.class);
        AlipayInBizContent alipayInBizContent = alipayInRequest.getAlipayInBizContent();

        // 1.申请绑定消息体
        // TODO 只是一种简单的文本响应方式，商户可以根据自身业务定制自己响应的响应方式
        AlipayArticleItem item = new AlipayArticleItem();
        item.setTitle("菜单响应");
        item.setDesc(buildMsgDesc());
        item.setImageUrl("http://pic.alipayobjects.com/e/201311/1PaQ27Go6H_src.jpg");
        item.setUrl("http://d.alipay.com");
        item.setActionName("下载钱包");

        // 2.申请绑定完整消息
        AlipayArticleMsg toAlipayArticleMsg = new AlipayArticleMsg();
        toAlipayArticleMsg.addItem(item);
        toAlipayArticleMsg.setAppId(alipayInBizContent.getAppId());
        toAlipayArticleMsg.setMsgType(MsgConstants.IMGTXT_MSG_TYPE);
        toAlipayArticleMsg.setCreateTime(new Date());
        toAlipayArticleMsg.setToUserId(alipayInBizContent.getFromUserId());

        // 3.申请绑定回复响应
        AlipayInArticleMsgResponse alipayInArticleMsgResponse = AlipayInArticleMsgResponse
            .getSuccessInstance();
        alipayInArticleMsgResponse.setAlipayArticleMsg(toAlipayArticleMsg);
        alipayInArticleMsgResponse
            .setMerchantMsg(AlipayArticleMsgFactory.toXml(toAlipayArticleMsg));

        inProcessContext.setAlipayInResponse(alipayInArticleMsgResponse);

        LoggerUtil.info(logger, OPERATION_NAME + ",执行菜单点击处理完毕.[alipayInArticleMsgResponse="
                                + alipayInArticleMsgResponse + "]");

    }

    /**
     * 构建消息响应
     * 
     * @return
     */
    private String buildMsgDesc() {

        StringBuilder msgBuilder = new StringBuilder(100);
        msgBuilder.append("这是一种菜单响应机制").append("\n").append("商户可以根据不同菜单响应不同的消息");

        return msgBuilder.toString();
    }

    /** 
     * @see com.alipay.demo.process.ServiceExecutorNameWire#getExecutorName()
     */
    @Override
    public String getExecutorName() {
        return ServiceTool.buildInServiceName(MsgConstants.EVENT_MSG_TYPE,
            MsgConstants.CLICK_EVENT_TYPE, MsgConstants.MenuKeys.MENU_MSG_RESP);
    }

}
