package ru.task.postgres.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaProducer {

    @Value("${kafka.topic.second}")
    String topic;

    KafkaTemplate<Object, User> kafkaTemplate;

    public KafkaProducer() {
        this.kafkaTemplate = KafkaConfig.kafkaTemplate();
    }

    public void send(Optional<User> user){
        try{
            kafkaTemplate.send(topic, user.get());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

