package com.sherzberg.zkleaderelection;

import org.springframework.context.event.EventListener;
import org.springframework.integration.leader.event.OnGrantedEvent;
import org.springframework.integration.leader.event.OnRevokedEvent;
import org.springframework.stereotype.Component;

@Component
public class LeaderHandler {

    @EventListener(OnGrantedEvent.class)
    public void start() {
        System.out.println("start");
    }

    @EventListener(OnRevokedEvent.class)
    public void stop() {
        System.out.println("stop");
    }

}
