package com.memory.controller;

import com.memory.dao.User;
import com.memory.dao.repo.UserRepository;
import com.memory.dao.CardGroup;
import com.memory.dao.repo.CardGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cardgroup")
public class CardGroupController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardGroupRepository cardGroupRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewCardGroup (@RequestParam String cardgroupname
            , @RequestParam long userid) {
        User u = userRepository.findById(userid);
        List<CardGroup> cgs = u.getCardGroups();
        u.setId(userid);
        CardGroup g = new CardGroup();

        g.setName(cardgroupname);
        cgs.add(g);
        u.setCardGroups(cgs);
        userRepository.save(u);
        return "Saved";
    }

    @PostMapping(path="/update") // Map ONLY POST Requests
    public @ResponseBody String updateGroup (@RequestParam String cardgroupname
            , @RequestParam long cardgroupid) {
        CardGroup g = new CardGroup();
        g.setId(cardgroupid);
        g.setName(cardgroupname);
        cardGroupRepository.save(g);
        return "Updated";
    }

    @PostMapping(path="/delete") // Map ONLY POST Requests
    public @ResponseBody String deleteGroup (@RequestParam long cardgroupid) {
        CardGroup g = new CardGroup();
        g.setId(cardgroupid);
        cardGroupRepository.delete(g);
        return "deleted";
    }
}