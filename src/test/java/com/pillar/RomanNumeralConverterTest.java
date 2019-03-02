package com.pillar;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter = new RomanNumeralConverter();

    private void assertSuccess(String expectedValue, ConversionResponse actualValue) {
        assertTrue(actualValue.success);
        assertEquals(expectedValue, actualValue.romanNumeral);
    }

    private void assertFailure(String expectedValue, ConversionResponse actualValue) {
        assertFalse(actualValue.success);
        assertEquals(expectedValue, actualValue.message);
    }

    @Test
    public void shouldConvertMultipleOfSameRomanNumeralFromArabicValue() {
        assertSuccess("II", converter.convertToRoman(2));
    }

    @Test
    public void shouldConvertSingleRomanNumeralFromArabicValue() {
        assertSuccess("I", converter.convertToRoman(1));
        assertSuccess("V", converter.convertToRoman(5));
        assertSuccess("X", converter.convertToRoman(10));
        assertSuccess("L", converter.convertToRoman(50));
        assertSuccess("C", converter.convertToRoman(100));
        assertSuccess("D", converter.convertToRoman(500));
        assertSuccess("M", converter.convertToRoman(1000));
    }

    @Test
    public void shouldConvertArabicValueToRomanUsingAllNumerals() {
        assertSuccess("MDCLXVI", converter.convertToRoman(1666));
    }

    @Test
    public void shouldConvertRomanNumeralUsingSubtractionFromArabicValue() {
        assertSuccess("IV", converter.convertToRoman(4));
    }

    @Test
    public void shouldDisallowArabicValues5000OrGreater() {
        assertFailure("Invalid arabic value input for conversion to roman.", converter.convertToRoman(5000));
    }

    @Test
    public void shouldDisallowArabicValuesLessThan1() {
        assertFailure("Invalid arabic value input for conversion to roman.", converter.convertToRoman(0));
    }

}
