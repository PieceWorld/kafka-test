package ru.task.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.task.kafka.model.KafkaProducer;

@RestController
public class UserController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping(value = "/start")
    public String sendId() {
        return kafkaProducer.sendId();
    }

}
