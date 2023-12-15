package com.memory.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cascade_user_group")
public class CardGroup {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private List<Card> cards;
}