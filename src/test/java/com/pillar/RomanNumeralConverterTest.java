package com.pillar;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void shouldConvertMultipleOfSameRomanNumeralFromArabicValue() {
        assertEquals("II", converter.convertToRoman(2));
    }

    @Test
    public void shouldConvertSingleRomanNumeralFromArabicValue() {
        assertEquals("I", converter.convertToRoman(1));
        assertEquals("V", converter.convertToRoman(5));
        assertEquals("X", converter.convertToRoman(10));
        assertEquals("L", converter.convertToRoman(50));
        assertEquals("C", converter.convertToRoman(100));
        assertEquals("D", converter.convertToRoman(500));
        assertEquals("M", converter.convertToRoman(1000));
    }

}
