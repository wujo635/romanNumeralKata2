package com.pillar;

public class ConversionResponse {

    public String message;
    public boolean success;
    public String romanNumeral;
    public Integer arabicValue;

    private ConversionResponse(boolean success, String romanNumeral, String message) {
        this.success = success;
        this.romanNumeral = romanNumeral;
        this.message = message;
    }

    public ConversionResponse(boolean success, int arabicValue, String message) {
        this.success = success;
        this.arabicValue= arabicValue;
        this.message = message;
    }

    public static ConversionResponse success(String romanNumeral) {
        return new ConversionResponse(true, romanNumeral, null);
    }

    public static ConversionResponse failure(String message) {
        return new ConversionResponse(false, null, message);
    }

    public static ConversionResponse success(int arabicValue) {
        return new ConversionResponse(true, arabicValue, null);
    }

}
