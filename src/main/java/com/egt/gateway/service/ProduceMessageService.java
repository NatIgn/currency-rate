package com.egt.gateway.service;

import com.egt.gateway.configuration.AppConfig;
import com.egt.gateway.entity.RequestEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProduceMessageService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    public ProduceMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage(String requestEntityString) {
        rabbitTemplate.convertAndSend(exchangeName, "currency.messages",
                requestEntityString);
        return "Message(" + requestEntityString + ")" + " has been produced.";
    }
}
