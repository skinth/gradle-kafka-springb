/*
Copyright (C) 2019 Stefano Salvagni

This file is part of gradle-kafka-springb.

gradle-kafka-springb is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

gradle-kafka-springb is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with gradle-kafka-springb. If not, see <https://www.gnu.org/licenses/>.
*/
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
        return msgRepo.findById(id).get();
    }
}