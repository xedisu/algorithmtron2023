package com.algorithmtron.utils;

import java.util.*;

public class Utils {
    public static int getMaxValueFromHashmap(Map<Character, Integer> characterFrequencyMap) {
        if (Objects.isNull(characterFrequencyMap)) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        for (char c : characterFrequencyMap.keySet()) {
            if (characterFrequencyMap.get(c) > max) {
                max = characterFrequencyMap.get(c);
            }
        }

        return max;
    }

    public static Map<Character, Integer> populateHashmap(String s) {
        if (Objects.isNull(s)) {
            return null;
        }

        Map<Character, Integer> returnHashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!returnHashMap.containsKey(c)) {
                returnHashMap.put(c, 1);
            } else {
                returnHashMap.put(c, returnHashMap.get(c) + 1);
            }
        }

        return returnHashMap;
    }

    public static Set<Character> generateSetWithCharsFromString(String stringInput) {
        Set<Character> set = new HashSet<>();

        if (Objects.isNull(stringInput)) {
            return set;
        }

        for (char c : stringInput.toCharArray()) {
            set.add(c);
        }

        return set;
    }

    public static boolean areAllCharactersOfStringFoundInSet(Set<Character> set, String word) {
        if (Objects.isNull(word)) {
            return false;
        }

        if (word.equals("") && !set.isEmpty()) {
            return false;
        }

        if (Objects.isNull(set) || word.length() < 1) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!set.contains(word.toLowerCase().charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
