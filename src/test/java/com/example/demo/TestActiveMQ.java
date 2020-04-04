package com.example.demo;

import com.example.springbootDemo.MainApp_Producer;
import com.example.springbootDemo.Queue_Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes=MainApp_Producer.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//由于是Web项目，Junit需要模拟ServletContext，因此测试类加上@WebAppConfiguration。
public class TestActiveMQ {

    @Resource  //相当于spring 的autowired
    private Queue_Producer queue_producer;

    @Test
    public void testsend(){
        queue_producer.producemsg();
    }

    @Test
    public void testsend1(){
        queue_producer.shceduleProduceMsg();
    }
}
