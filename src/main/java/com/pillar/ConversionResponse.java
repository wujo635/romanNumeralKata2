package com.pillar;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionResponse that = (ConversionResponse) o;
        return success == that.success &&
                Objects.equals(message, that.message) &&
                Objects.equals(romanNumeral, that.romanNumeral) &&
                Objects.equals(arabicValue, that.arabicValue);
    }

    @Override
    public String toString() {
        return "ConversionResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", romanNumeral='" + romanNumeral + '\'' +
                ", arabicValue=" + arabicValue +
                '}';
    }
}
