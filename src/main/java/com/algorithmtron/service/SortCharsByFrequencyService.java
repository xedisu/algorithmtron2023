package com.algorithmtron.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.algorithmtron.utils.Utils.getMaxValueFromHashmap;
import static com.algorithmtron.utils.Utils.populateHashmap;

@Service
public class SortCharsByFrequencyService {
    /**
     * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
     *
     * @param s - represent the string that is given as input.
     * @return - Return the sorted string. If there are multiple answers, return any of them.
     */
    public String sortCharsByFrequency(String s) {
        Map<Character, Integer> characterFrequencyMap = populateHashmap(s);
        Map<Integer, String> characterFrequencyMapWithSwitchedKeyAndValue = generateSortedCharsMapByFrequency(characterFrequencyMap);

        return buildSortedStringOfCharsByFrequency(characterFrequencyMapWithSwitchedKeyAndValue, characterFrequencyMap);
    }

    public static Map<Integer, String> generateSortedCharsMapByFrequency(Map<Character, Integer> characterFrequencyMap) {
        if (characterFrequencyMap == null) {
            return new HashMap<>();
        }

        Map<Integer, String> characterFrequencyMapWithSwitchedKeyAndValue = new HashMap<>();

        for (char c : characterFrequencyMap.keySet()) {
            if (characterFrequencyMap.get(c) == null) {
                continue;
            }
            int freq = characterFrequencyMap.get(c);
            StringBuilder keysOfFreq = new StringBuilder();

            if (characterFrequencyMapWithSwitchedKeyAndValue.get(freq) == null) {
                for (int i = 0; i < freq; i++) {
                    keysOfFreq.append(c);
                }
            } else {
                String prevKeysOfFreq = characterFrequencyMapWithSwitchedKeyAndValue.get(freq);
                for (int i = 0; i < freq; i++) {
                    keysOfFreq.append(c);
                }
                keysOfFreq.insert(0, prevKeysOfFreq);
            }
            characterFrequencyMapWithSwitchedKeyAndValue.put(freq, keysOfFreq.toString());
        }

        return characterFrequencyMapWithSwitchedKeyAndValue;
    }

    public static String buildSortedStringOfCharsByFrequency(Map<Integer, String> invertedKeyValMap,
                                                             Map<Character, Integer> characterFrequencyMap) {
        int max = getMaxValueFromHashmap(characterFrequencyMap);
        StringBuilder sortedString = new StringBuilder();

        for (int i = max; i > 0; i--) {
            if (invertedKeyValMap.containsKey(i)) {
                sortedString.append(invertedKeyValMap.get(i));
            }
        }
        return sortedString.toString();
    }
}
