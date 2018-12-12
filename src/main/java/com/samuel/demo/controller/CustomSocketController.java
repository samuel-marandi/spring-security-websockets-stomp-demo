package com.samuel.demo.controller;

import com.samuel.demo.model.Greeting;
import com.samuel.demo.model.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Slf4j
@Controller
public class CustomSocketController {

    private SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting messageHandler(@Payload HelloMessage message,
                                   SimpMessageHeaderAccessor headerAccessor,
                                   Principal principal){
        log.info("Custom Message Handler Triggered");
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

//        return new CustomMessage(true, "Stay Alive");
//    @SubscribeMapping("/topic/greetings")
//    public Greeting initMessage() {
//        log.info("Custom Message INIT Triggered");
//        return new Greeting("Hello, " + "TRY 1" + "!");
//    }
}
