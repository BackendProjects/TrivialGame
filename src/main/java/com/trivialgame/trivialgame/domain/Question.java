package com.trivialgame.trivialgame.domain;

import com.trivialgame.trivialgame.enums.DifficultyType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(value = EnumType.STRING)
    private DifficultyType difficultyType;

    private boolean isNiche;

    @ManyToOne
    private Category category;

    @OneToMany
    List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private Game game;

    @OneToMany
    List<Answer> answers = new ArrayList<>();

    public Question(String text, DifficultyType difficultyType, boolean isNiche, Category category, List<Tag> tags, Game game, List<Answer> answers) {
        this.text = text;
        this.difficultyType = difficultyType;
        this.isNiche = isNiche;
        this.category = category;
        this.tags = tags;
        this.game = game;
        this.answers = answers;
    }
}
