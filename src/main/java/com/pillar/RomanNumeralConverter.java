package com.pillar;

public class RomanNumeralConverter {
    public String convertToRoman(int arabicValue) {
        return new String(new char[arabicValue]).replace("\0","I");
    }
}
