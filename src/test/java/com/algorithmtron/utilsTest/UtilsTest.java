package com.algorithmtron.utilsTest;

import com.algorithmtron.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.algorithmtron.utils.Utils.areAllCharactersOfStringFoundInSet;
import static com.algorithmtron.utils.Utils.generateSetWithCharsFromString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class UtilsTest {

    @Test
    void populateHashmapValidInput() {
        String s = "test";
        Map<Character, Integer> map = Utils.populateHashmap(s);

        assertEquals(2, map.get('t'));
        assertEquals(1, map.get('e'));
        assertEquals(1, map.get('s'));
    }

    @Test
    void populateHashmapEmptyStringInput() {
        Map<Character, Integer> map = Utils.populateHashmap("");

        assertNull(map.get(""));
    }

    @Test
    void populateHashmapNullInput() {
        assertNull(Utils.populateHashmap(null));
    }

    @Test
    void populateHashmapSpecialCharactersInput() {
        String s = "^&test";
        Map<Character, Integer> map = Utils.populateHashmap(s);

        assertEquals(2, map.get('t'));
        assertEquals(1, map.get('e'));
        assertEquals(1, map.get('s'));
        assertEquals(1, map.get('^'));
        assertEquals(1, map.get('&'));
    }

    @Test
    void getMaxValueFromHashmapValidInput() {
        Map<Character, Integer> map = Utils.populateHashmap("substitute");
        int max = Utils.getMaxValueFromHashmap(map);

        assertEquals(3, max);
    }

    @Test
    void getMaxValueFromHashmapValidInputOneElem() {
        Map<Character, Integer> map = Utils.populateHashmap("t");
        int max = Utils.getMaxValueFromHashmap(map);

        assertEquals(1, max);
    }

    @Test
    void getMaxValueFromHashmapNullInput() {
        int max = Utils.getMaxValueFromHashmap(null);

        assertEquals(Integer.MIN_VALUE, max);
    }

    @Test
    void getMaxValueFromHashmapWhichIsEmpty() {
        Map<Character, Integer> map = Utils.populateHashmap("");
        int max = Utils.getMaxValueFromHashmap(map);

        assertEquals(Integer.MIN_VALUE, max);
    }

    @Test
    void getMaxValueFromHashmapSpecialCharactersVariationValidInput() {
        Map<Character, Integer> map = Utils.populateHashmap("%%subst%%itute");
        int max = Utils.getMaxValueFromHashmap(map);

        assertEquals(4, max);
    }

    @Test
    void generateSetWithCharsFromStringValidInput() {
        Set<Character> characterSet = generateSetWithCharsFromString("qwer");
        Set<Character> testSet = new HashSet<>();

        testSet.add('q');
        testSet.add('w');
        testSet.add('e');
        testSet.add('r');

        Assertions.assertEquals(testSet, characterSet);
    }

    @Test
    void generateSetWithCharsFromStringEmptyInput() {
        Set<Character> characterSet = generateSetWithCharsFromString("");
        Set<Character> testSet = new HashSet<>();

        Assertions.assertEquals(testSet, characterSet);
    }

    @Test
    void generateSetWithCharsFromStringNullInput() {
        Set<Character> characterSet = generateSetWithCharsFromString(null);
        Set<Character> testSet = new HashSet<>();

        Assertions.assertEquals(testSet, characterSet);
    }

    @Test
    void areAllCharactersOfStringFoundInSetValidInputTrueOutcome() {
        Set<Character> characterSet = generateSetWithCharsFromString("qwer");
        String word = "qwer";

        Assertions.assertTrue(areAllCharactersOfStringFoundInSet(characterSet, word));
    }

    @Test
    void areAllCharactersOfStringFoundInSetValidInputFalseOutcome() {
        Set<Character> characterSet = generateSetWithCharsFromString("qwer");
        String word = "qwera";

        Assertions.assertFalse(areAllCharactersOfStringFoundInSet(characterSet, word));
    }

    @Test
    void areAllCharactersOfStringFoundInSetEmptyStringInput() {
        Set<Character> characterSet = generateSetWithCharsFromString("qwer");
        String word = "";

        Assertions.assertFalse(areAllCharactersOfStringFoundInSet(characterSet, word));
    }

    @Test
    void areAllCharactersOfStringFoundInSetWithNullSetInput() {
        String word = "qwer";

        Assertions.assertFalse(areAllCharactersOfStringFoundInSet(null, word));
    }

    @Test
    void areAllCharactersOfStringFoundInSetWithNullInputs() {
        Set<Character> characterSet = null;
        String word = null;

        Assertions.assertFalse(areAllCharactersOfStringFoundInSet(characterSet, word));
    }
}
