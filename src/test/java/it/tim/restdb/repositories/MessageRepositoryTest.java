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
package it.tim.restdb.repositories;

import it.tim.restdb.entities.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MessageRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void findMessageById() {
        Message msg = new Message();
        msg.setMessage("Test repo message");
        msg.setTopic("comics");

        entityManager.persist(msg);
        entityManager.flush();

        Message res = messageRepository.findById(msg.getId()).get();

        assertTrue(res.getId() == msg.getId());

    }

    @Test
    public void findMessagesByTopic() {
        Message msg = new Message();
        msg.setMessage("Test repo message one");
        msg.setTopic("test_repo_topic");
        entityManager.persist(msg);

        Message msgT = new Message();
        msgT.setMessage("Test repo message two");
        msgT.setTopic("test_repo_topic");
        entityManager.persist(msgT);
        entityManager.flush();

        List<Message> res = (List<Message>)messageRepository.findAllByTopic("test_repo_topic");

        assertTrue(res.size() == 2);
    }

}
