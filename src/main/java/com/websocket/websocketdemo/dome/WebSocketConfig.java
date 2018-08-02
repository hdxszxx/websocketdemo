package com.websocket.websocketdemo.dome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 配置webSocket进行再spring中注册
 * @author MacFan
 * user:created by MacFan
 * DATE: 2018/8/2
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(),"/myHandler");
    }

    @Bean
    public MyHandler myHandler(){
        return new MyHandler();
    }
    /**
     * xml 方式
     <beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:websocket="http://www.springframework.org/schema/websocket"
     xsi:schemaLocation="
     http://www.springframework.org/schema/beans
     http://www.springframework.org/schema/beans/spring-beans.xsd
     http://www.springframework.org/schema/websocket
     http://www.springframework.org/schema/websocket/spring-websocket.xsd">

     <websocket:handlers>
     <websocket:mapping path="/myHandler" handler="myHandler"/>
     </websocket:handlers>

     <bean id="myHandler" class="org.springframework.samples.MyHandler"/>

     </beans>
     */
}
