package com.algorithmtron.controller;

import com.algorithmtron.service.FindFirstAndLastIndexOfElementSortedArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.algorithmtron.utils.Utils.convertStringToIntArray;

@Controller
public class FindFirstAndLastIndexOFElementSortedArrayController {

    @Autowired
    FindFirstAndLastIndexOfElementSortedArrayService findFirstAndLastIndexOfElementSortedArrayService;

    @GetMapping("/findFirstAndLastIndexOfElementSortedArray")
    public String getFindFirstAndLastIndexOfElementSortedArrayService(Model model) {
        return "findFirstAndLastIndexOfElementSortedArrayInputPage";
    }

    @PostMapping("/findFirstAndLastIndexOfElementSortedArray")
    public String postFindFirstAndLastIndexOfElementSortedArray(@RequestParam String arrayOfNumbers, @RequestParam int target, Model model) {
        model.addAttribute("numbersRequestDTO",
                findFirstAndLastIndexOfElementSortedArrayService.searchRange(convertStringToIntArray(arrayOfNumbers), target));

        return "findFirstAndLastIndexOfElementSortedArrayOutputPage";
    }

}
