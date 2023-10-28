package com.algorithmtron.controller;

import com.algorithmtron.entity.WordFinder;
import com.algorithmtron.model.WordsRequestDTO;
import com.algorithmtron.repository.KeyBoardWordFinderRepository;
import com.algorithmtron.service.KeyboardWordFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KeyBoardWordFinderController {
    @Autowired
    KeyboardWordFinderService keyboardWordFinderService;
    @Autowired
    KeyBoardWordFinderRepository keyBoardWordFinderRepository;
    @PostMapping("/keyboardWordFinder")
    public String postKeyboardWordFinder(@ModelAttribute("wordsRequestDTO") WordsRequestDTO wordsRequestDTO, Model model) {
        String wordsIn[] = wordsRequestDTO.getWordsToCheck().split(" ");
        String wordsOut[] = keyboardWordFinderService.findWords(wordsIn);

        model.addAttribute("wordsRequestDTO", wordsOut);
        WordFinder wordFinder = new WordFinder();
        wordFinder.setWordsInput(wordsIn);
        wordFinder.setWordsOutput(wordsOut);
        keyBoardWordFinderRepository.save(wordFinder);

        return "keyboardWordFinderOutputPage";
    }

    @GetMapping("/keyboardWordFinder")
    public String getKeyboardWordFinder(Model model) {
        WordsRequestDTO wordsRequestDTO = new WordsRequestDTO();

        model.addAttribute("wordsRequestDTO", wordsRequestDTO);

        return "keyboardWordFinderInputPage";
    }
}
