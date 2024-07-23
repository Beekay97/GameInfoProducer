package com.example.gameinfoproducer.service;

import com.example.gameinfoproducer.model.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaWrongMessageProducerService {
    private KafkaTemplate<String, String> kafkaTemplate;
    private final static String TOPIC_NAME = "game-info";

    @Autowired
    public KafkaWrongMessageProducerService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String gameInfo){
        kafkaTemplate.send(TOPIC_NAME, gameInfo);
    }

}
