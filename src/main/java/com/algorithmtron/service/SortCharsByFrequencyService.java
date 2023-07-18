package com.algorithmtron.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SortCharsByFrequencyService {

    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }
        int max = Integer.MIN_VALUE;

        for (char c : hm.keySet()) {
            if (hm.get(c) > max) {
                max = hm.get(c);
            }
        }
        Map<Integer, String> intKeyHm = new HashMap<>();

        for (char c : hm.keySet()) {
            int freq = hm.get(c);
            String keysOfFreq = "";

            if (intKeyHm.get(freq) == null) {
                for (  int i = 0 ; i < freq ; i++) {
                    keysOfFreq += c;
                }
            } else {
                String prevKeysOfFreq = intKeyHm.get(freq);
                for (int i = 0; i < freq; i++) {
                    keysOfFreq += c;
                }
                keysOfFreq = prevKeysOfFreq + keysOfFreq;
            }
            intKeyHm.put(freq, keysOfFreq);
        }

        for (int i = max; i > 0; i--) {
            if (intKeyHm.containsKey(i)) {
                sb.append(intKeyHm.get(i));
            }
        }

        return sb.toString();
    }
}
