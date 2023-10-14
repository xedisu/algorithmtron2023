package com.algorithmtron.controller;

import com.algorithmtron.model.WordRequestDTO;
import com.algorithmtron.service.SortCharsByFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SortCharsByFrequencyController {

    @Autowired
    SortCharsByFrequencyService sortCharsByFrequencyService;

    @GetMapping("/SortCharsByFrequency")
    public String getSortCharsByFrequency(Model model) {
        WordRequestDTO wordRequestDTO = new WordRequestDTO();

        model.addAttribute("wordRequestDTO", wordRequestDTO);

        return "sortCharsByFrequencyInputPage";
    }

    @PostMapping("/SortCharsByFrequency")
    public String postSortCharsByFrequency(@ModelAttribute("wordRequestDTO") WordRequestDTO wordRequestDTO, Model model) {

        model.addAttribute("wordRequestDTO", sortCharsByFrequencyService.sortCharsByFrequency(wordRequestDTO.getWordToCheck()));

        return "sortCharsByFrequencyOutputPage";
    }
}
