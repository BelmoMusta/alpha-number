package com.mustabelmo.numers.words;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class AbstractNumberInWords {
    public static final BigDecimal TEN = BigDecimal.valueOf(10);
    protected final Rules rules;
    private final BigDecimal value;
    protected String symbol;
    
    protected boolean decimalPartToFraction;
    
    public AbstractNumberInWords(String value, Rules rules) {
        this.value = new BigDecimal(value);
        this.rules = rules;
    }
    
    public AbstractNumberInWords(Number value, Rules rules) {
        this(value.toString(), rules);
    }
    
    public AbstractNumberInWords(Double value, Rules rules) {
        this.value = BigDecimal.valueOf(value);
        this.rules = rules;
    }
    
    public String toLetters() {
        LinkedList<NumberPart> numberParts = getIntegerNumberParts(value);
        Appender sb = new Appender();
        String collect = numberParts.stream()
                .map(Object::toString)
                .collect(Collectors.joining(rules.getUnitsSeparator()));
        sb.append(collect);
        BigDecimal fractionalPart = value.remainder(BigDecimal.ONE);
        if (fractionalPart.compareTo(BigDecimal.ZERO) > 0) {
            int numberOfDecimalPlaces = getNumberOfDecimalPlaces(value);
            BigDecimal pow = TEN.pow(numberOfDecimalPlaces);
            BigDecimal decimalPart = fractionalPart.multiply(pow);
            LinkedList<NumberPart> decimalParts = getIntegerNumberParts(decimalPart);
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
        if (symbol != null && !symbol.isEmpty()) {
            sb.append(' ')
                    .append(symbol);
        }
        return sb.toString();
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
    
    protected LinkedList<NumberPart> getIntegerNumberParts(BigDecimal value) {
        LinkedList<NumberPart> numberParts = new LinkedList<>();
        BigInteger bigIntegerValue = value.toBigInteger();
        BigInteger oneThousand = BigInteger.valueOf(1000L);
        int unit = 0;
        do {
            int modulo = bigIntegerValue.mod(oneThousand).intValue();
            NumberPart numberPart = new NumberPart(modulo);
            if (value.compareTo(BigDecimal.ZERO) == 0
                    || !numberPart.isEmpty()) {
                numberParts.addFirst(numberPart);
            }
            numberPart.setUnit(unit++);
            
            bigIntegerValue = bigIntegerValue.divide(oneThousand);
        } while (bigIntegerValue.compareTo(BigInteger.ZERO) != 0);
        
        if (numberParts.isEmpty()) {
            numberParts.addFirst(new NumberPart(0));
        }
        return numberParts;
    }
    
    int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
        return Math.max(0, bigDecimal.stripTrailingZeros().scale());
    }
    
    private class NumberPart {
        private final int number;
        private int unit = -1;
        private final int onesDigit;
        private final int tensDigit;
        private final int hundredsDigit;
        
        public NumberPart(int number) {
            onesDigit = (number % 100) % 10;
            tensDigit = (number % 100) / 10;
            hundredsDigit = number / 100;
            this.number = number;
        }
        
        @Override
        public String toString() {
            Appender sb = new Appender();
            traitHundreds(sb);
            if (rules.isInRangeOfSpecialCases(onesDigit, tensDigit)) {
                if (!sb.isEmpty()) {
                    sb.append(rules.getSeparator());
                }
                sb.append(rules.getSpecialCases(onesDigit, tensDigit));
            } else {
                if (rules.onesComeAfterTens()) {
                    traitTens(sb);
                    traitOnes(sb);
                } else {
                    traitOnes(sb);
                    traitTens(sb);
                }
            }
            traitUnits(sb);
            return sb.toString();
        }
        
        private void traitUnits(Appender sb) {
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
        
        private void traitOnes(Appender sb) {
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
                if(tensDigit>0) {
                    sb.append(rules.getTensSeparator());
                } else {
                    sb.append(rules.getSeparator());
                }
            }
            sb.append(ones);
        }
        
        private void traitTens(Appender sb) {
            
            String tens;
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
        
        private void traitHundreds(Appender sb) {
            if (hundredsDigit > 0) {
                String hundredName = rules.getHundredName(number);
                sb.append(rules.getHundreds(hundredsDigit));
                if ((hundredsDigit != 1 || !rules.isSpecialCaseFor1())
                        && (hundredsDigit != 2 || !rules.isSpecialCaseFor2())) {
                    sb.append(rules.getHundredSeparator())
                            .append(rules.getHundredName(number));
                }
            }
        }
        
        public void setUnit(int unit) {
            this.unit = unit;
        }
        
        public boolean isEmpty() {
            return number == 0;
        }
    }
    
    public Number getValue() {
        return value;
    }
    
    public void setDecimalPartToFraction(boolean decimalPartToFraction) {
        this.decimalPartToFraction = decimalPartToFraction;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
