package com.memory.dao.repo;

import com.memory.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(long id);
}