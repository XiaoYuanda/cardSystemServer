package com.memory.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "cascade_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private List<CardGroup> cardGroups;

}