package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumer_TX {
    public static final String ACTIVEMQ_URL = "tcp://11.40.1.102:61616";
    public static final String QUEUE_NAME = "Topic-Persist";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
   //     Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(queue);
        while(true){
            TextMessage receive = (TextMessage)consumer.receive(5000L);
            if(null!=receive){
                System.out.println("收到消息"+receive.getText());
                //表示签收  Session.CLIENT_ACKNOWLEDGE
                receive.acknowledge();
            }else {
                break;
            }
        }
        consumer.close();
     //   session.commit();
        session.close();
        connection.close();

    }
}
