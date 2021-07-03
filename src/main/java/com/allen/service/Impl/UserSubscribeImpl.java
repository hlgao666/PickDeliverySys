package com.allen.service.Impl;


import com.allen.service.UserSubscribe;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * @author Allen
 * @date 2021/6/10 15:01
 */

@Service
public class UserSubscribeImpl implements UserSubscribe {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    //订阅
    public boolean subscribe(String authorId, String userId){
        //创建rabbitAdmin管理器
        RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());

        DirectExchange exchange = new DirectExchange("article_subscribe");

        rabbitAdmin.declareExchange(exchange);

        Queue queue = new Queue("article_subscribe"+userId, true);

        Binding binding = BindingBuilder.bind(queue).to(exchange).with(authorId);

        String userKey = "article_subscribe"+userId;
        String authorKey = "article_subscribe"+authorId;

        if(redisTemplate.boundSetOps(userKey).isMember(authorId)){
            redisTemplate.boundSetOps(userKey).remove(authorId);
            redisTemplate.boundSetOps(authorKey).remove(userId);
            rabbitAdmin.removeBinding(binding);
            return false;
        }

        redisTemplate.boundSetOps(userKey).add(authorId);
        redisTemplate.boundSetOps(authorKey).add(userId);
        System.out.println("添加绑定");
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(binding);
        System.out.println("绑定成功");

        return true;
    }

}
