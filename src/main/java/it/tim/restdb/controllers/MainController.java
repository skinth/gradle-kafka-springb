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

import it.tim.restdb.entities.Message;
import it.tim.restdb.services.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    IConsumerService consumerService;

    @GetMapping("/")
    public List<String> index() {
        List<String> lLinks = new ArrayList(){{
            add("http://localhost:9000/messages");
        }};
        for (Message m : consumerService.findAll()) {
            lLinks.add("http://localhost:9000/message/"+m.getId());
        }
        return lLinks;
    }

    @GetMapping("/messages")
    public List<Message> findMessages() {
        return consumerService.findAll();
    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable("id") Integer id) {
        return consumerService.findMessage(id);
    }

}
