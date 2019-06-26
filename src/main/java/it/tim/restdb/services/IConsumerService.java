package it.tim.restdb.services;

import it.tim.restdb.entities.Message;
import java.util.List;

public interface IConsumerService {

    public long count();
    public List<Message> findAll();
    public Message findMessage(Integer  id);
}
