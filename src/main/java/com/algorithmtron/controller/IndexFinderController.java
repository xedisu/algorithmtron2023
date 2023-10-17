package com.algorithmtron.controller;

import com.algorithmtron.service.IndexFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.algorithmtron.utils.Utils.convertStringToIntArray;

@Controller
public class IndexFinderController {

    @Autowired
    IndexFinderService indexFinderService;

    @GetMapping("/indexFinder")
    public String getIndexFinder(Model model) {
        return "indexFinderInputPage";
    }

    @PostMapping("/indexFinder")
    public String postIndexFinder(@RequestParam String arrayOfNumbers, @RequestParam int target, Model model) {
        model.addAttribute("numbersRequestDTO",
                indexFinderService.searchRange(convertStringToIntArray(arrayOfNumbers), target));

        return "indexFinderOutputPage";
    }
}
