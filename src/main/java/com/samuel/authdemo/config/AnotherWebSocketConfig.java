//package com.samuel.authdemo.config;
//
//import com.samuel.authdemo.utils.MyMessageHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket
//public class AnotherWebSocketConfig implements WebSocketConfigurer {
//
//    @Bean
//    public WebSocketHandler myMessageHandler() {
//        return new MyMessageHandler();
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myMessageHandler(), "/my-websocket-endpoint");
//    }
//}
