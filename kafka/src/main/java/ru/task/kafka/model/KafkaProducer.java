package ru.task.kafka.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class KafkaProducer{

    @Value("${kafka.topic.first}")
    String topic;

    KafkaTemplate<Object, Integer> kafkaTemplate;

    public KafkaProducer() {
        this.kafkaTemplate = KafkaConfig.kafkaTemplate();
    }

    public String sendId() {
        int id = computationId();
        return send(id);
    }

    private int computationId() {
        Random rnd = new Random();
        return rnd.nextInt(10) + 1;
    }

    private String send(Integer num) {
        try {
            kafkaTemplate.send(topic, num);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return "Sending not successful: " + e.getMessage();
        }

        return "Sending successful: " + num;
    }
}
