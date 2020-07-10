package com.qin.myspringboot.rabbitmq;

import com.qin.myspringboot.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(String mes){
        System.out.println(mes);
    }
}
