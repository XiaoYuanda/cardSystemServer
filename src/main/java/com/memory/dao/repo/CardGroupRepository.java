package com.memory.dao.repo;

import com.memory.dao.CardGroup;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CardGroupRepository extends JpaRepository<CardGroup, Integer> {
    CardGroup findById(long id);
}