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
package it.tim.restdb.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    Message msg;

    @Before
    public void createMessage() {
        msg = new Message();
        msg.setId(1);
        msg.setMessage("Test message");
        msg.setTopic("test");
    }

    @Test
    public void messageState() {
        assertTrue(1 == msg.getId());
        assertSame("test", msg.getTopic());
        assertSame("Test message", msg.getMessage());
    }

}
