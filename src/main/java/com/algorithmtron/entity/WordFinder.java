package com.algorithmtron.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WordFinder {
    @Id
    private int id;
    private String[] wordsInput;
    private String[] wordsOutput;
}
