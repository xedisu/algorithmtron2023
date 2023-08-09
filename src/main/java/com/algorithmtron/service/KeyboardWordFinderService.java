package com.algorithmtron.service;

import com.algorithmtron.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class KeyboardWordFinderService {
    /**
     * Given an array of strings words,
     * return the words that can be typed using letters of the alphabet on only one row of American keyboard.
     * the first row consists of the characters "qwertyuiop",
     * the second row consists of the characters "asdfghjkl", and
     * the third row consists of the characters "zxcvbnm".
     * @param 'words' - represent the array of strings given as input.
     * @return - Return the array of words that have their characters contained on any single line of characters on a keyboard.
     */
    private enum RowsOfCharacterLettersOnKeyboard {qwertyuiop, asdfghjkl, zxcvbn}

    public String[] findWords(String[] words) {
        if (words == null || (words.length == 1 && words[0].equals(""))) {
            return new String[0];
        }

        Set<Character> firstRowSet = Utils.generateSetWithCharsFromString(String.valueOf(RowsOfCharacterLettersOnKeyboard.qwertyuiop));
        Set<Character> secondRowSet = Utils.generateSetWithCharsFromString(String.valueOf(RowsOfCharacterLettersOnKeyboard.asdfghjkl));
        Set<Character> thirdRowSet = Utils.generateSetWithCharsFromString(String.valueOf(RowsOfCharacterLettersOnKeyboard.zxcvbn));
        List<String> resultArray = new ArrayList<>();

        for (String word : words) {
            boolean isWordFoundInFirstRow = Utils.areAllCharactersOfStringFoundInSet(firstRowSet, word);
            boolean isWordFoundInSecondRow = Utils.areAllCharactersOfStringFoundInSet(secondRowSet, word);
            boolean isWordFoundInThirdRow = Utils.areAllCharactersOfStringFoundInSet(thirdRowSet, word);

            if (isWordFoundInFirstRow || isWordFoundInSecondRow || isWordFoundInThirdRow) {
                resultArray.add(word);
            }
        }

        return resultArray.toArray(new String[0]);
    }
}
