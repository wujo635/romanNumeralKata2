package com.pillar;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void shouldConvert1ToI() {
        assertEquals("I", converter.convertToRoman(1));
    }

    @Test
    public void shouldConvert2toII() {
        assertEquals("II", converter.convertToRoman(2));
    }

    @Test
    public void shouldConvert5toV() {
        assertEquals("V", converter.convertToRoman(5));
    }

}
