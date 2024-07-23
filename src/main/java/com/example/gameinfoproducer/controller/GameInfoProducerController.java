package com.example.gameinfoproducer.controller;

import com.example.gameinfoproducer.model.GameInfo;
import com.example.gameinfoproducer.service.KafkaProducerService;
import com.example.gameinfoproducer.service.KafkaWrongMessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameInfoProducerController {
    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private KafkaWrongMessageProducerService kafkaWrongMessageProducerService;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody GameInfo gameInfo){
        System.out.println("Publishing message to Kafka");
        kafkaProducerService.sendMessage(gameInfo);
        System.out.printf("Successfully published Game Info: %n%s", gameInfo);
        return "Successfully published message";
    }

    @PostMapping("/wrongMsg")
    public String wrongPublish(@RequestBody String jsonString){
        System.out.println("Publishing wrong message to Kafka");
        kafkaWrongMessageProducerService.sendMessage(jsonString);
        System.out.printf("Successfully published message: %n%s", jsonString);
        return "Successfully published message";
    }
}
