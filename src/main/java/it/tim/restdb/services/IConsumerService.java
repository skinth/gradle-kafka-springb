package it.tim.restdb.services;

import it.tim.restdb.entities.Message;
import java.util.List;

public interface IConsumerService {

    public List<Message> findAll();
}
