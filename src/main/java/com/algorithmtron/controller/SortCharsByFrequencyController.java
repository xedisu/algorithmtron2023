package com.algorithmtron.controller;

import com.algorithmtron.model.StringDTO;
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
        StringDTO stringDTO = new StringDTO();

        model.addAttribute("stringDTO", stringDTO);

        return "SortCharsByFrequencyInputPage";
    }

    @PostMapping("/SortCharsByFrequency")
    public String postSortCharsByFrequency(@ModelAttribute("stringDTO") StringDTO stringDTO, Model model) {

        model.addAttribute("stringDTO", sortCharsByFrequencyService.sortCharsByFrequency(stringDTO.getWordToCheck()));

        return "SortCharsByFrequencyOutputPage";
    }
}
