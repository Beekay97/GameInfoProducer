package com.example.gameinfoproducer.service;

import com.example.gameinfoproducer.model.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private KafkaTemplate<String, GameInfo> kafkaTemplate;
    private final static String TOPIC_NAME = "game-info";

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, GameInfo> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(GameInfo gameInfo){
        kafkaTemplate.send(TOPIC_NAME, gameInfo);
    }
}
