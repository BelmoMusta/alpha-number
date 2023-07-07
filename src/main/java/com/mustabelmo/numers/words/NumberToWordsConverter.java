package com.mustabelmo.numers.words;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberToWordsConverter implements INumberToWordsConverter {
    private static final ThreadLocal<NumberToWordsConverter> CONVERTER_HOLDER = new ThreadLocal<>();
    public static final BigDecimal TEN = BigDecimal.valueOf(10);
    
    public static NumberToWordsConverter getInstance() {
        if (CONVERTER_HOLDER.get() == null) {
            CONVERTER_HOLDER.set(new NumberToWordsConverter());
        }
        return CONVERTER_HOLDER.get();
    }
    public String convert(BigDecimal number, Rules rules, String symbol, boolean decimalPartToFraction) {
        
        LinkedList<String> numberParts = getIntegerNumberParts(number, rules);
        Appender sb = new Appender();
        String collect = numberParts.stream()
                .collect(Collectors.joining(rules.getUnitsSeparator()));
        sb.append(collect);
        addDecimalPart(number, rules, decimalPartToFraction, sb);
        if (symbol != null && !symbol.isEmpty()) {
            sb.append(' ')
                    .append(symbol);
        }
        return sb.toString();
    }
    
    private void addDecimalPart(BigDecimal number, Rules rules, boolean decimalPartToFraction, Appender sb) {
        BigDecimal fractionalPart = number.remainder(BigDecimal.ONE);
        if (fractionalPart.compareTo(BigDecimal.ZERO) > 0) {
            int numberOfDecimalPlaces = getNumberOfDecimalPlaces(number);
            BigDecimal pow = TEN.pow(numberOfDecimalPlaces);
            BigDecimal decimalPart = fractionalPart.multiply(pow);
            LinkedList<String> decimalParts = getIntegerNumberParts(decimalPart, rules);
            if (decimalPartToFraction) {
                sb.append(rules.getJunction());
                sb.append(decimalPart.toBigInteger())
                        .append("/")
                        .append(pow);
            } else {
                sb.append(rules.getDecimalConnector());
                String decimalPartAsLetters = decimalParts.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(rules.getUnitsSeparator()));
                int numberOfZerosAfterDecimalSymbol = getNumberOfZerosAfterDecimalSymbol(fractionalPart);
                String zeros = IntStream.range(0, numberOfZerosAfterDecimalSymbol)
                        .mapToObj(i -> rules.getZero())
                        .collect(Collectors.joining(" "));
                if (!zeros.isEmpty()) {
                    sb.append(zeros);
                    sb.append(' ');
                }
                sb.append(decimalPartAsLetters);
            }
        }
    }
    
    protected LinkedList<String> getIntegerNumberParts(BigDecimal value, Rules rules) {
        LinkedList<String> numberParts = new LinkedList<>();
        BigInteger bigIntegerValue = value.toBigInteger();
        BigInteger oneThousand = BigInteger.valueOf(1000L);
        int unit = 0;
        do {
            int modulo = bigIntegerValue.mod(oneThousand).intValue();
            int onesDigit = modulo % 10;
            int tensDigit = (modulo % 100) / 10;
            if (value.compareTo(BigDecimal.ZERO) == 0
                    || modulo != 0) {
                Appender sb = new Appender();
                String hundreds = traitHundreds(modulo, rules);
                sb.append(hundreds);
                if (rules.isInRangeOfSpecialCases(onesDigit, tensDigit)) {
                    if (!sb.isEmpty()) {
                        sb.append(rules.getSeparator());
                    }
                    sb.append(rules.getSpecialCases(onesDigit, tensDigit));
                } else {
                    if (rules.onesComeAfterTens()) {
                        traitTens(modulo, rules, sb);
                        traitOnes(modulo, unit, rules, sb);
                    } else {
                        traitOnes(modulo, unit, rules, sb);
                        traitTens(modulo, rules, sb);
                    }
                }
                traitUnits(modulo, unit, rules, sb);
                numberParts.addFirst(sb.toString());
            }
            bigIntegerValue = bigIntegerValue.divide(oneThousand);
            unit++;
            
        } while (bigIntegerValue.compareTo(BigInteger.ZERO) != 0);
        
        if (numberParts.isEmpty()) {
            numberParts.addFirst(rules.getZero());
        }
        return numberParts;
    }
    
    private String traitHundreds(int number, Rules rules) {
        Appender appender = new Appender();
        int hundredsDigit = number / 100;
        if (hundredsDigit > 0) {
            appender.append(rules.getHundreds(hundredsDigit));
            if ((hundredsDigit != 1 || !rules.isSpecialCaseFor1())
                    && (hundredsDigit != 2 || !rules.isSpecialCaseFor2())) {
                appender.append(rules.getHundredSeparator())
                        .append(rules.getHundredName(number));
            }
        }
        return appender.toString();
    }
    
    private void traitTens(int number, Rules rules, Appender sb) {
        int onesDigit = number % 10;
        int tensDigit = (number % 100) / 10;
        final String tens;
        if (tensDigit == 1) {
            tens = rules.getTen(onesDigit);
        } else {
            tens = rules.getMultipleOfTen(tensDigit);
        }
        if (!sb.isEmpty() && !tens.isEmpty()) {
            sb.append(rules.getSeparator());
        }
        sb.append(tens);
    }
    
    private void traitOnes(int number, int unit, Rules rules, Appender sb) {
        int onesDigit = number % 10;
        int tensDigit = (number % 100) / 10;
        String ones = "";
        if (unit >= 1) {
            if (number == 1 && (rules.isSpecialCaseFor1())) {
                return;
            }
            if (number == 2 && (rules.isSpecialCaseFor2())) {
                return;
            }
        }
        if ((onesDigit > 0 && tensDigit != 1) || number < 10) {
            ones = rules.getOne(onesDigit);
        }
        if (!sb.isEmpty() && !ones.isEmpty()) {
            if (tensDigit > 0) {
                sb.append(rules.getTensSeparator());
            } else {
                sb.append(rules.getSeparator());
            }
        }
        sb.append(ones);
    }
    
    private void traitUnits(int number, int unit, Rules rules, Appender sb) {
        if (number > 0) {
            final String unitString;
            if (rules.isSpecialCaseFor1() && number % 10 == 1) {
                unitString = rules.getUnitString(unit);
            } else if (rules.isSpecialCaseFor2() && number == 2) {
                unitString = rules.getDoubledUnitString(unit);
            } else if (rules.isInRangeOfPlurals(number)) {
                unitString = rules.getPluralUnitString(unit);
            } else {
                if (rules.shouldUnitBeAccusative(number)) {
                    unitString = rules.getAccusativeUnitString(unit);
                } else {
                    unitString = rules.getUnitString(unit);
                }
            }
            if (!unitString.isEmpty() && !sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(unitString);
        }
    }
    
    int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
        return Math.max(0, bigDecimal.stripTrailingZeros().scale());
    }
    
    private int getNumberOfZerosAfterDecimalSymbol(BigDecimal fractionalPart) {
        BigDecimal temp = fractionalPart;
        int zeros = 0;
        while (temp.compareTo(BigDecimal.ONE) < 0) {
            temp = temp.multiply(TEN);
            zeros++;
        }
        
        return zeros - 1;
    }
}
