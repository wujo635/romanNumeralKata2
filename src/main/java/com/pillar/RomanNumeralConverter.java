package com.pillar;

public class RomanNumeralConverter {

    private String[] numerals = new String[]{"M", "D", "C", "L", "X", "V", "IV", "I"};
    private int[] values = new int[]{1000, 500, 100, 50, 10, 5, 4, 1};

    public String convertToRoman(int arabicValue) {
        if (isOutOfRomanNumeralRange(arabicValue)) {
            return "Invalid arabic value input for conversion to roman.";
        }
        String romanNumeral = "";
        int remainingToConvert = arabicValue;
        while (remainingToConvert > 0) {
            for (int index = 0; index < numerals.length; index++) {
                int numeralCount = remainingToConvert / values[index];
                romanNumeral += new String(new char[numeralCount]).replace("\0", numerals[index]);
                remainingToConvert -= numeralCount * values[index];
            }
        }
        return romanNumeral;
    }

    private boolean isOutOfRomanNumeralRange(int arabicValue) {
        return arabicValue > 4999 || arabicValue < 1;
    }
}
