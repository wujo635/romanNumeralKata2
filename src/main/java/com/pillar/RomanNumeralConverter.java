package com.pillar;

public class RomanNumeralConverter {

    private String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public ConversionResponse convertToRoman(int arabicValue) {
        if (isOutOfRomanNumeralRange(arabicValue)) {
            return ConversionResponse.failure("Invalid arabic value input for conversion to roman.");
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
        return ConversionResponse.success(romanNumeral);
    }

    private boolean isOutOfRomanNumeralRange(int arabicValue) {
        return arabicValue > 4999 || arabicValue < 1;
    }

    public ConversionResponse convertToArabic(String romanNumeral) {
        if (isInvalidRomanNumeral(romanNumeral) || romanNumeral.isEmpty()) {
            return ConversionResponse.failure("Failed to convert Roman numeral to Arabic value.");
        }
        int arabicValue = 0;
        String remainingToConvert = romanNumeral;
        for (int index = 0; index < numerals.length; index++) {
            int occurences = 0;
            while (remainingToConvert.startsWith(numerals[index])) {
                remainingToConvert = remainingToConvert.substring(numerals[index].length());
                occurences++;
            }
            if (occurences > 3) {
                return ConversionResponse.failure("Failed to convert Roman numeral to Arabic value.");
            }
            arabicValue += occurences * values[index];
        }
        return ConversionResponse.success(arabicValue);
    }

    private boolean isInvalidRomanNumeral(String romanNumeral) {
        return !romanNumeral.matches("[M]*[CM]*[D]*[CD]*[C]*[XC]*[L]*[XL]*[X]*[IX]*[V]*[IV]*[I]*");
    }
}
