package com.sherzberg.zkleaderelection;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.zookeeper.config.LeaderInitiatorFactoryBean;

@EnableIntegration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LeaderInitiatorFactoryBean leaderInitiator(CuratorFramework client) {
        return new LeaderInitiatorFactoryBean().setClient(client).setPath("/stuff").setRole("cluster");
    }

    @Bean
    public LeaderHandler leaderHandler() {
        return new LeaderHandler();
    }

}
