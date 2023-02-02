package com.trivialgame.trivialgame.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "game")
    List<Question> questions = new ArrayList<>();

    @ManyToOne
    private Player player;

    public Game(List<Question> questions, Player player) {
        this.questions = questions;
        this.player = player;
    }
}
