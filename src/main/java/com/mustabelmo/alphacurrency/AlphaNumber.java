package com.mustabelmo.alphacurrency;

import java.math.BigDecimal;

/**
 * Created by Belmokhtar on 25/10/2017.
 */
public class AlphaNumber extends Number {
    public static final String SPACE = " ";
    public static final long THOUSAND = 1000L;
    public static final int HUNDRED = 100;
    public static final int ONE = 1;
    public static final int ZERO = 0;
    public static final int THREE = 3;

    private Number value;
    private String unit;
    private boolean decimalPartToLetters;

    public AlphaNumber() {
        decimalPartToLetters = true;
    }

    public AlphaNumber(Number value) {
        this();
        this.value = value;
    }

    public AlphaNumber(Number value, String unit) {
        this(value);
        this.unit = unit;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Gets the letter format of the number value.
     *
     * @return String
     */
    public String toLetters() {
        BigDecimal bigDecimal = BigDecimal.valueOf(value.doubleValue());
        bigDecimal = bigDecimal.setScale(Utils.NB_DECIMALS, BigDecimal.ROUND_FLOOR)
                .stripTrailingZeros();
        String number = bigDecimal.toString();
        String[] split = number.split("\\.");
        String intValue = split[ZERO];
        String decimalValue = String.valueOf(ZERO);

        if (split.length > ONE) {
            decimalValue = split[ONE];
        }

        StringBuilder sb = new StringBuilder(convertValue(intValue));
        if (unit != null && !unit.isEmpty()) {
            sb.append(unit).append(SPACE);
        }

        long decVal = Long.parseLong(decimalValue);
        if (decVal != ZERO) {
            String decimalPart;
            if (decimalPartToLetters) {
                decimalPart = convertValue(decimalValue);
            } else {
                decimalPart = String.valueOf(decVal);
            }

            sb.append(Utils.COMA)
                    .append(decimalPart);
        }
        return sb.toString();
    }

    /**
     * Converts the given integer value value to letters.
     *
     * @param intValue the integer value.
     * @return StringBuilder of the equivalent value in letters.
     */
    private String convertValue(String intValue) {
        final StringBuilder stringBuilder = new StringBuilder();
        long intPart = Long.parseLong(intValue);
        int range = ZERO;
        while (intPart != ZERO) {
            long remainder = intPart % THOUSAND;
            if (remainder != ZERO) {
                String space = "";

                if (range > ZERO) {
                    space = SPACE;
                }

                stringBuilder.insert(ZERO, convert(remainder)
                        + space + Utils.getUnitAtRange(range) + SPACE);
            }

            intPart /= THOUSAND;
            range += THREE;
        }
        return stringBuilder.toString();
    }

    /**
     * Converts a an integer value less than 1000 to letters.
     *
     * @param number the value to convert.
     * @return String.
     */
    private String convert(long number) {

        StringBuilder stringBuilder = new StringBuilder();

        int result = (int) (number / HUNDRED);
        int remainder = (int) (number % HUNDRED);

        if (result == ONE) {
            stringBuilder.append(Utils.CENT)
                    .append(SPACE);
        } else if (result != ZERO) {
            stringBuilder.append(Utils.getAlphaFor(result))
                    .append(SPACE)
                    .append(Utils.CENT)
                    .append(SPACE);
        }
        stringBuilder.append(Utils.getAlphaFor(remainder));
        return stringBuilder.toString();
    }

    public boolean isDecimalPartToLetters() {
        return decimalPartToLetters;
    }

    public void setDecimalPartToLetters(boolean decimalPartToLetters) {
        this.decimalPartToLetters = decimalPartToLetters;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{\n")
                .append("value : ")
                .append(value)
                .append(",\n")
                .append("letters: ")
                .append(toLetters())
                .append("\n}")
                .toString();
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }
}

