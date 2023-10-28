package com.algorithmtron.service;

import com.algorithmtron.entity.WordFinder;
import com.algorithmtron.repository.KeyBoardWordFinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.algorithmtron.enums.RowsOfCharacterLettersOnKeyboard.*;
import static com.algorithmtron.utils.Utils.areAllCharactersOfStringFoundInSet;
import static com.algorithmtron.utils.Utils.generateSetWithCharsFromString;
import static java.lang.String.valueOf;

@Service
public class KeyboardWordFinderService {
    /**
     * Given an array of strings words,
     * return the words that can be typed using letters of the alphabet on only one row of American keyboard.
     * the first row consists of the characters "qwertyuiop",
     * the second row consists of the characters "asdfghjkl", and
     * the third row consists of the characters "zxcvbnm"
     *
     * @param words - represent the array of strings given as input.
     * @return - Return the array of words that have their characters contained on any single line of characters on a keyboard.
     */
    public String[] findWords(String[] words) {
        if (Objects.isNull(words) || (words.length == 1 && words[0].equals(""))) {
            return new String[0];
        }

        Set<Character> firstRowSet = generateSetWithCharsFromString(valueOf(qwertyuiop));
        Set<Character> secondRowSet = generateSetWithCharsFromString(valueOf(asdfghjkl));
        Set<Character> thirdRowSet = generateSetWithCharsFromString(valueOf(zxcvbn));
        List<String> resultArray = new ArrayList<>();

        for (String word : words) {
            boolean isWordFoundInFirstRow = areAllCharactersOfStringFoundInSet(firstRowSet, word);
            boolean isWordFoundInSecondRow = areAllCharactersOfStringFoundInSet(secondRowSet, word);
            boolean isWordFoundInThirdRow = areAllCharactersOfStringFoundInSet(thirdRowSet, word);

            if (isWordFoundInFirstRow || isWordFoundInSecondRow || isWordFoundInThirdRow) {
                resultArray.add(word);
            }
        }

        String[] output = resultArray.toArray(new String[0]);



        return output;
    }
}
