package com.qin.myspringboot.rabbitmq;

import com.qin.myspringboot.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitmqConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(String mes , Channel channel , Message message) throws IOException {
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println(mes);
    }
}
