package com.pillar;

public class RomanNumeralConverter {

    private String[] numerals = new String[]{"V", "I"};
    private int[] values = new int[]{5, 1};

    public String convertToRoman(int arabicValue) {
        String romanNumeral = "";
        int remainingToConvert = arabicValue;
        while (remainingToConvert > 0) {
            for (int index = 0; index < numerals.length; index++) {
                int numeralCount = remainingToConvert/values[index];
                romanNumeral += new String(new char[numeralCount]).replace("\0",numerals[index]);
                remainingToConvert -= numeralCount * values[index];
            }
        }
        return romanNumeral;
    }
}
