package com.samuel.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GreetingController {

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(@Payload HelloMessage message,
//                             SimpMessageHeaderAccessor headerAccessor,
//                             Principal principal,
//                             SocketState socketState) throws Exception {
//        String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
//        headerAccessor.setSessionId(sessionId);
//        log.info("Session Id:" +sessionId);
//        log.info("Name :"+ principal.getName());

//        if(socketState.getConnectionOpen()) {
//            Thread.sleep(1000); // simulated delay
//            if(socketState.getUsername().equals(principal.getName()) && socketState.getSessionId().equals(headerAccessor.getSessionId())) {
//                return new Greeting("You are already logged in!");
//            }
//        } else {
//            Thread.sleep(1000); // simulated delay
//            socketState.setSessionId(headerAccessor.getSessionId());
//            socketState.setUsername(principal.getName());
//            socketState.setConnectionOpen(true);
//        }
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//    }
}
