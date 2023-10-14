package com.algorithmtron.controller;

import com.algorithmtron.model.WordsRequestDTO;
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

    @PostMapping("/keyboardWordFinder")
    public String postKeyboardWordFinder(@ModelAttribute("wordsRequestDTO") WordsRequestDTO wordsRequestDTO, Model model) {
        String words[] = wordsRequestDTO.getWordsToCheck().split(" ");

        model.addAttribute("wordsRequestDTO", keyboardWordFinderService.findWords(words));

        return "keyboardWordFinderOutputPage";
    }

    @GetMapping("/keyboardWordFinder")
    public String getKeyboardWordFinder(Model model) {
        WordsRequestDTO wordsRequestDTO = new WordsRequestDTO();

        model.addAttribute("wordsRequestDTO", wordsRequestDTO);

        return "keyboardWordFinderInputPage";
    }
}
