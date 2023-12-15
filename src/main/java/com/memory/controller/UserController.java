package com.memory.controller;

import com.memory.dao.CardGroup;
import com.memory.dao.User;
import com.memory.dao.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String username
            , @RequestParam String password) {

        System.out.print("PostMapping:/add");
        User n = new User();
        n.setUsername(username);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="/update") // Map ONLY POST Requests
    public @ResponseBody String updateUser (@RequestParam long id
            , @RequestParam String username
            , @RequestParam String password) {
        System.out.print("PostMapping:/update");
        User n = new User();
        n.setId(id);
        n.setUsername(username);
        n.setPassword(password);
        userRepository.save(n);
        return "updated";
    }

//    @GetMapping(path="/users")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        System.out.print("GetMapping:/users");
//        List<User> users = userRepository.findAll();
//
//        return users;
//    }

    @GetMapping(value = "/{id}")
    public @ResponseBody User getUser(@PathVariable long id) {
        System.out.print("GetMapping:/{id}");
        return userRepository.findById(id);
    }
}