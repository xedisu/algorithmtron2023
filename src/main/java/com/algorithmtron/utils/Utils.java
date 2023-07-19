package com.algorithmtron.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static int getMaxValueFromHashmap(Map<Character, Integer> characterFrequencyMap) {
        if (characterFrequencyMap == null) {
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
        if (s == null) {
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
}
