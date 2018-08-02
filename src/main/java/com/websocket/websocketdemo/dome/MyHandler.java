package com.websocket.websocketdemo.dome;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.IOException;

/**
 * @author MacFan
 * user:created by MacFan
 * DATE: 2018/8/2
 */
public class MyHandler extends BinaryWebSocketHandler {

    /**
     * 在创建连接后触发的回调
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接成功");
    }

    /**
     * 收到消息的之后的回调（任何消息类型）
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
    }

    /**
     * 收到消息的之后的回调（文本消息类型）
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("接收数据成功："+message. getPayload());
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到消息的之后的回调（二进制消息类型）
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        super.handleBinaryMessage(session, message);
    }

    /**
     * 收到消息的之后的回调（ByteBuffer消息类型）
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    /**
     * 传输消息出现错误时触发的回调
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("发生了错误");
    }

    /**
     * 当关闭连接后触发的回调
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("关闭了连接");
    }

    /**
     * 是否处理分片消息
     * @return
     */
    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }
}
