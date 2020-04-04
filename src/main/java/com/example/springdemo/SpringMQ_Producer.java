package com.example.springdemo;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringMQ_Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
      /*  ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-activemq.xml");
        SpringMQ_Producer sringMQ_producer =(SpringMQ_Producer) ctx.getBean("springMQ_Producer");
        sringMQ_producer.jmsTemplate.send((session)->{
            TextMessage textMessage = session.createTextMessage("spring-mq");
            return textMessage;

        });
        System.out.println("sssssssssssss over");*/
    }
}
