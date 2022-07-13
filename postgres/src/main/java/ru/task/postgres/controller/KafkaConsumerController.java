package ru.task.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.task.postgres.model.KafkaProducer;
import ru.task.postgres.model.User;
import ru.task.postgres.repository.UsersRepository;

import java.util.Optional;


@Component
public class KafkaConsumerController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    KafkaProducer kafkaProducer;

    @KafkaListener(topics = "#{'${kafka.topic.first}'}", groupId = "group_id")
    public void getUserId(String userId) {
        Optional<User> user = usersRepository.findById(Long.valueOf(userId));
        kafkaProducer.send(user);
    }


}
