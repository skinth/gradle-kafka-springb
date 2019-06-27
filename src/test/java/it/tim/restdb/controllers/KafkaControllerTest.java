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
package it.tim.restdb.controllers;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class KafkaControllerTest extends AbstractControllerTest{

    @Before
    public void createMockMvc() {
        setUp();
    }

    @Test
    public void publishMessage() throws Exception{
        String uri = "/kafka/publish";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).param("message","Message for test")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}
