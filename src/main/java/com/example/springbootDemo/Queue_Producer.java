package com.example.springbootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableAutoConfiguration
@ImportAutoConfiguration
public class Queue_Producer {
    //发现jmsMessagingTemplate不能自动注入，因此添加两个注解EnableAutoConfiguration和
    //ImportAutoConfiguration
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void producemsg(){
        jmsMessagingTemplate.convertAndSend( queue,"************test");
    }

    @Scheduled(fixedDelay = 3000)
    public void shceduleProduceMsg(){
        jmsMessagingTemplate.convertAndSend( queue,"************scheduletest");
        System.out.println("schedule........");
    }
}
