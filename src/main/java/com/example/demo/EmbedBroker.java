package com.example.demo;

import org.apache.activemq.broker.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbedBroker {
    public static final Logger logger= LoggerFactory.getLogger(EmbedBroker.class);
    public static void main(String[] args) throws Exception {
        //把迷你版的mq实例服务器嵌入到java程序里
        //比如当linux的mq崩溃，或者自己电脑本地测试，可以用自己java手写的broker来代替mq
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
        logger.info("顺利启动");
        logger.warn("broker启动");
        logger.error("broker启动");
    }
}
