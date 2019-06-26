package it.tim.restdb.repositories;

import it.tim.restdb.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
