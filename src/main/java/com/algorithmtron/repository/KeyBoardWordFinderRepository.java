package com.algorithmtron.repository;

import com.algorithmtron.entity.WordFinder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyBoardWordFinderRepository extends JpaRepository<WordFinder, Integer> {
}
