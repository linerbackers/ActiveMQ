package com.example.demo;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumer_Topic_Persist {

  //  public static final String ACTIVEMQ_URL = "tcp://11.40.1.102:61616";
  public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String TOPIC_NAME = "Topic-Persist";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("lin");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageConsumer consumer = session.createDurableSubscriber(topic,"xxx备注");
        connection.start();
        TextMessage receive;
        while(true){
            receive = (TextMessage)consumer.receive(5000L);
            if(null!=receive){
                System.out.println("收到消息"+receive.getText());
            }else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();

    }
}
