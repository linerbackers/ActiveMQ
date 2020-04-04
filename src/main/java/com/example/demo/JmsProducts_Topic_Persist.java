package com.example.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProducts_Topic_Persist {

   // public static final String ACTIVEMQ_URL = "tcp://11.40.1.102:61616";
    //测试broker
    public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String TOPIC_NAME = "Topic-Persist";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂，按照给定的url地址，采用默认用户名和密码admin
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //通过连接工厂，获得连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        //创建session会话
        //两个参数 第一个事务，第二个签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地topic
        Topic topic = session.createTopic(TOPIC_NAME);
        //创建消息的生产者
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for (int i = 0; i < 3; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("tx msg" + i);
            //通过messageProducer 发给mq
            producer.send(textMessage);
        }
        System.out.println("消息发送成功");

        producer.close();
      //  session.commit();//只有在事务设置为true时，才需要这么做，否则发送不到mq
        session.close();
        connection.close();


    }
}
