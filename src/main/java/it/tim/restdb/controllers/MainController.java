package it.tim.restdb.controllers;

import it.tim.restdb.entities.Message;
import it.tim.restdb.services.Consumer;
import it.tim.restdb.services.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    IConsumerService consumerService;

    @GetMapping("/")
    public @ResponseBody List<String> index() {
        List<String> lLinks = new ArrayList(){{
            add("http://localhost:9000/messages");
        }};
        for (Message m : consumerService.findAll()) {
            lLinks.add("http://localhost:9000/message/"+m.getId());
        }
        return lLinks;
    }

    @GetMapping("/messages")
    public @ResponseBody List<Message> findMessages() {
        return consumerService.findAll();
    }

    @GetMapping("/message/{id}")
    public @ResponseBody Message getMessage(@PathVariable("id") Integer id) {
        return consumerService.findMessage(id);
    }

    @GetMapping("/error")
    public @ResponseBody String error() {
        return "Error!";
    }

}
