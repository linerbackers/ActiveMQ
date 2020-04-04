package com.example.springbootDemo;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

@Component
@EnableJms  //这一步很重要，开启jms的一些注解
public class configBean {

    @Value("${myqueue}")
    private String myqueue;

    @Bean  //相当于<bean id="" class=""/>
    public ActiveMQQueue queue(){
        return new ActiveMQQueue(myqueue);

    }
}
