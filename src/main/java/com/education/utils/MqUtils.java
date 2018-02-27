package com.education.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * ActiveMQ工具类
 *
 * @author Lvxianya
 * @create 2018/2/1
 */
@Configuration
@EnableJms
public class MqUtils {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("springboot.queue.test");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("springboot.topic.test");
    }
}
