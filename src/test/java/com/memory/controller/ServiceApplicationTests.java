package com.memory.controller;

import com.memory.dao.CardGroup;
import com.memory.dao.User;
import com.memory.dao.repo.CardGroupRepository;
import com.memory.dao.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Test
	public void testR(){

		System.out.print(userRepository.findById(1L));
	}

}
