package com.qin.myspringboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qin.myspringboot.config.RabbitConfig;
import com.qin.myspringboot.springboot.entity.Person;
import com.qin.myspringboot.springboot.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.spring.web.json.Json;

@Slf4j
@SpringBootTest
public class DataBaseTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IPersonService personService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test01() throws JsonProcessingException {
        Person person = personService.getById(1);
        redisTemplate.opsForValue().set("person",objectMapper.writeValueAsString(person));

    }

    @Test
    public void test02() throws JsonProcessingException {
        log.error("hello");
        redisTemplate.opsForHash().put("persons" , "陈意涵"  , "20");

    }
    @Test
    public void test03(){
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,"QUEUE","陈意涵");
    }

}
