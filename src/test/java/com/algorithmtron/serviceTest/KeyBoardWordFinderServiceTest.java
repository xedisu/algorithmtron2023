package com.algorithmtron.serviceTest;

import com.algorithmtron.service.KeyboardWordFinderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class KeyBoardWordFinderServiceTest {

    @Test
    void KeyboardWordFinderServiceWithValidInput() {
        String[] inputArr = {"Hello", "Alaska", "Dad", "Peace", "sfd"};
        String[] resArr = {"Alaska", "Dad", "sfd"};
        KeyboardWordFinderService keyboardWordFinderService = new KeyboardWordFinderService();

        Assertions.assertEquals(Arrays.toString(resArr), Arrays.toString(keyboardWordFinderService.findWords(inputArr)));
    }

    @Test
    void KeyboardWordFinderServiceWithEmptyInput() {
        String[] inputArr = {};
        KeyboardWordFinderService keyboardWordFinderService = new KeyboardWordFinderService();

        Assertions.assertEquals(Arrays.toString(new String[0]), Arrays.toString(keyboardWordFinderService.findWords(inputArr)));
    }

    @Test
    void KeyboardWordFinderServiceWithNullInputOfWords() {
        String[] resArr = {};
        KeyboardWordFinderService keyboardWordFinderService = new KeyboardWordFinderService();

        Assertions.assertEquals(Arrays.toString(resArr), Arrays.toString(keyboardWordFinderService.findWords(null)));
    }
}
