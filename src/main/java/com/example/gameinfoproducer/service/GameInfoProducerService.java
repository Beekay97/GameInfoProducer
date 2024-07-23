package com.example.gameinfoproducer.service;

import com.example.gameinfoproducer.model.GameInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GameInfoProducerService {
    @Autowired
    KafkaProducerService kafkaProducerService;

//    @PostConstruct
//    public void initialize(){
//        Random random = new Random();
//        int count = random.nextInt(100);
//        IntStream.range(0, count)
//                .mapToObj(i -> new GameInfo()
//                        .setGameId(generateRandomString(random,8))
//                        .setUserId(generateRandomString(random,5))
//                        .setGameScore(random.nextLong())
//                        .setGameTime(System.currentTimeMillis())
//                ).forEach(gameInfo -> kafkaProducerService.sendMessage(gameInfo));
//    }

    public static String generateRandomString(Random random, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return random.ints(length, 0, characters.length())
                .mapToObj(characters::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
