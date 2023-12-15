package com.memory.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//import java.sql.Date;

@Entity
@Data
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition="text")
    private String question;
    @Column(columnDefinition="text")
    private String answer;
    private Date nextreviewtime;
    private Integer level;
}