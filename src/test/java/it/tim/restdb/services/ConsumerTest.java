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

import static org.junit.Assert.*;

import it.tim.restdb.entities.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerTest {

    @Autowired
    private Consumer consumer;

    @Test
    public void testCount() {
        assertTrue(consumer.count() >= 0);
    }

    @Test
    public void findAllMessages() {
        assertTrue(consumer.findAll().size() >= 0);
    }

    @Test
    public void findMessage() {
        if (consumer.findAll().size() > 0)
            assertTrue(consumer.findMessage(consumer.findAll().get(0).getId()) instanceof Message);
    }
}