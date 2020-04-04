package com.example.springdemo;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringMQ_Consumer {
 /*   @Autowired
    private JmsTemplate jmsTemplate;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-activemq.xml");
        SpringMQ_Consumer springMQ_Consumer =(SpringMQ_Consumer) ctx.getBean("springMQ_Consumer");
        TextMessage receive = (TextMessage) springMQ_Consumer.jmsTemplate.receive();
        System.out.println(receive);
    }*/
}
