package com.samuel.authdemo.utils;

import com.samuel.authdemo.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.Objects;

@Slf4j
@Component
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private SimpUserRegistry simpUserRegistry;

    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) throws NullPointerException {

        log.info("Subscription Triggered");

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());

        StompCommand command = headerAccessor.getCommand();
        if (Objects.equals(command, StompCommand.SUBSCRIBE)) {

            log.info("SUBSCRIBE IF CONDITION TRIGGERED");
            String sessionId = headerAccessor.getSessionId();
            String stompSubscriptionId = headerAccessor.getSubscriptionId();
            String destination = headerAccessor.getDestination();
            String user = Objects.requireNonNull(headerAccessor.getUser()).getName();

            int destinationCount =
                    (int) simpUserRegistry
                            .findSubscriptions(simpSubscription -> simpSubscription
                                    .getSession()
                                    .getUser()
                                    .getName()
                                    .equals(user))
                            .stream()
                            .filter(item -> item.getDestination()
                                    .equals(destination))
                            .count();

            log.info("Destination From Request: "+ destination);
            log.info("Stomp Subscription Id From Request: "+stompSubscriptionId);
            log.info("Session Id From Request: " + sessionId);
            log.info("Number of User From Server: "+ simpUserRegistry.getUserCount());
            log.info("Destinations for "+ user + " are... " + destinationCount);

            switch (destinationCount) {
                case 1:
                    template.convertAndSend(destination, new Greeting("Welcome, You are now connected"));
                    break;
                default:
                    template.convertAndSend(destination, new Greeting("You are already connected"));
            }
        }
    }
}

