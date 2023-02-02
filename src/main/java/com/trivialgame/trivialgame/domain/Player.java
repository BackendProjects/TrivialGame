package com.trivialgame.trivialgame.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "player")
    List<Game> questions = new ArrayList<>();

    public Player(String name, List<Game> questions) {
        this.name = name;
        this.questions = questions;
    }
}
