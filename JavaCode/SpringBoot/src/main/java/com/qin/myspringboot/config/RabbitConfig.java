package com.qin.myspringboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    //定义队列名称
    public static final String QUEUE = "helloQueue";

    //创建交换机名称
    public static final String EXCHANGE = "helloExchange";

    //创建队列
    @Bean(QUEUE)
    public Queue QUEUE() {
        Queue queue = new Queue(QUEUE);
        return queue;
    }

    //创建交换机
    @Bean(EXCHANGE)
    public Exchange EXCHANGE() {
        return ExchangeBuilder.directExchange(EXCHANGE).durable(true).build();
    }

    //绑定交换机和队列
    @Bean
    public Binding BINDING_QUEUE_EXCHANGE(@Qualifier(QUEUE) Queue queue,
                                          @Qualifier(EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE).noargs();

    }

}
