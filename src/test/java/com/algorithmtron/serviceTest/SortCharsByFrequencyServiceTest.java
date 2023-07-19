package com.algorithmtron.serviceTest;

import com.algorithmtron.service.SortCharsByFrequencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SortCharsByFrequencyServiceTest {

    @Test
    void buildSortedStringOfCharsByFrequencyValidInput() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', 1);
        characterIntegerMap.put('r', 1);
        characterIntegerMap.put('e', 2);
        characterIntegerMap.put('g', 2);
        characterIntegerMap.put('x', 3);

        Map<Integer, String> invertedStringIntegerMap =
                SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertEquals("xxxeeggrt",
                SortCharsByFrequencyService.buildSortedStringOfCharsByFrequency(invertedStringIntegerMap, characterIntegerMap));
    }

    @Test
    void buildSortedStringOfCharsByFrequencyDoesNotContainKey() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', 1);

        Map<Integer, String> invertedStringIntegerMap = new HashMap<>();
        invertedStringIntegerMap.put(2, "t");

        assertEquals("",
                SortCharsByFrequencyService.buildSortedStringOfCharsByFrequency(invertedStringIntegerMap, characterIntegerMap));
    }

    @Test
    void buildSortedStringOfCharsByFrequencyContainsKey() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', 1);

        Map<Integer, String> invertedStringIntegerMap = new HashMap<>();
        invertedStringIntegerMap.put(1, "t");

        assertEquals("t",
                SortCharsByFrequencyService.buildSortedStringOfCharsByFrequency(invertedStringIntegerMap, characterIntegerMap));
    }

    @Test
    void buildSortedStringOfCharsByFrequencyEmptyInput() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        Map<Integer, String> invertedStringIntegerMap =
                SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertEquals("",
                SortCharsByFrequencyService.buildSortedStringOfCharsByFrequency(invertedStringIntegerMap, characterIntegerMap));
    }

    @Test
    void buildSortedStringOfCharsByFrequencyNullInput() {
        Map<Character, Integer> characterIntegerMap = null;

        Map<Integer, String> invertedStringIntegerMap =
                SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertEquals("",
                SortCharsByFrequencyService.buildSortedStringOfCharsByFrequency(invertedStringIntegerMap, characterIntegerMap));
    }

    @Test
    void generateSortedCharsMapByFrequencyValidInput() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', 1);
        characterIntegerMap.put('r', 1);
        characterIntegerMap.put('e', 2);
        characterIntegerMap.put('g', 2);
        characterIntegerMap.put('x', 3);

        Map<Integer, String> invertedKeyValueCharacterIntegerMap = SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertEquals("eegg", invertedKeyValueCharacterIntegerMap.get(2));
        assertEquals("xxx", invertedKeyValueCharacterIntegerMap.get(3));
        assertEquals("rt", invertedKeyValueCharacterIntegerMap.get(1));
    }

    @Test
    void generateSortedCharsMapByFrequencyWhenMapContainsNullValues() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', null);

        Map<Integer, String> invertedKeyValueCharacterIntegerMap = SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertTrue(invertedKeyValueCharacterIntegerMap.isEmpty());
    }

    @Test
    void generateSortedCharsMapByFrequencyWhenMapWhenMapContainsOneNonNullElement() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('t', 1);

        Map<Integer, String> invertedKeyValueCharacterIntegerMap = SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertFalse(invertedKeyValueCharacterIntegerMap.isEmpty());
    }

    @Test
    void generateSortedCharsMapByFrequencyEmptyInput() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        Map<Integer, String> invertedKeyValueCharacterIntegerMap = SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertNull(invertedKeyValueCharacterIntegerMap.get(0));
    }

    @Test
    void generateSortedCharsMapByFrequencyNullInput() {
        Map<Character, Integer> characterIntegerMap = null;

        Map<Integer, String> invertedKeyValueCharacterIntegerMap = SortCharsByFrequencyService.generateSortedCharsMapByFrequency(characterIntegerMap);

        assertTrue(invertedKeyValueCharacterIntegerMap.isEmpty());
    }
}
