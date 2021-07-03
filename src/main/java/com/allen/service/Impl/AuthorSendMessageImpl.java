package com.allen.service.Impl;

import com.allen.service.AuthorSendMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Allen
 * @date 2021/6/10 16:18
 */

@Service
public class AuthorSendMessageImpl implements AuthorSendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String authorId){
        rabbitTemplate.convertAndSend("article_subscribe",authorId,"message: author"+authorId+System.currentTimeMillis());
    }
}
