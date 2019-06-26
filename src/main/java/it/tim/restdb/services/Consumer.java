package it.tim.restdb.services;

import it.tim.restdb.entities.Message;
import it.tim.restdb.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Consumer implements IConsumerService{

    @Autowired
    private MessageRepository msgRepo;

    private final String TOPIC = "comics";

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consume(String message){
        Message m = new Message();
        m.setTopic(TOPIC);
        m.setMessage(message);
        msgRepo.save(m);
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
    }

    @Override
    public long count() {
        return msgRepo.count();
    }

    @Override
    public List<Message> findAll() {
        return (List<Message>) msgRepo.findAll();
    }

    @Override
    public Message findMessage(Integer id) {
        return findAll().stream().filter(it -> it.getId() == id).findFirst().get();
    }
}