package com.algorithmtron.controller;

import com.algorithmtron.model.WordsDTO;
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
    public String postKeyboardWordfinder(@ModelAttribute("wordsDTO") WordsDTO wordsDTO, Model model) {
        String words[] = wordsDTO.getWords().split(" ");

        model.addAttribute("wordsDTO", keyboardWordFinderService.findWords(words));

        return "keyboardWordFinderOutputPage";
    }

    @GetMapping("/keyboardWordFinder")
    public String getKeyboardWordFinder(Model model) {
        WordsDTO wordsDTO = new WordsDTO();

        model.addAttribute("wordsDTO", wordsDTO);

        return "keyboardWordFinderInputPage";
    }
}
