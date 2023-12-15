package com.memory.controller;

import com.memory.dao.Card;
import com.memory.dao.repo.CardRepository;
import com.memory.dao.CardGroup;
import com.memory.dao.repo.CardGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/card")
public class CardController {
    @Autowired
    private CardGroupRepository cardGroupRepository;
    @Autowired
    private CardRepository cardRepository;

    @PostMapping(path="/add/{groupid}") // Map ONLY POST Requests
    public @ResponseBody String addNewCardByGroupId (@PathVariable("groupid") long groupid, @RequestBody Card card) {
        CardGroup cardGroup = cardGroupRepository.findById(groupid);
        List<Card> cards = cardGroup.getCards();
        cards.add(card);
        cardGroup.setCards(cards);
        cardGroupRepository.save(cardGroup);
        return "Saved";
    }


    @PostMapping(path="/update/{cardid}") // Map ONLY POST Requests
    public @ResponseBody String updateCardById (@PathVariable("cardid") long cardid, @RequestBody Card card) {
        cardRepository.save(card);
        return "Saved";
    }

    @PostMapping(path="/delete/{cardid}") // Map ONLY POST Requests
    public @ResponseBody String deleteCardById (@PathVariable("cardid") long cardid) {
        Card c = new Card();
        c.setId(cardid);
        cardRepository.delete(c);
        return "deleted";
    }
}