package com.mustabelmo.numers.words;

import java.math.BigDecimal;
import java.util.Locale;


public class NumberInWords {
    protected final Rules rules;
    private final BigDecimal value;
    private String symbol;
    private boolean decimalPartToFraction;
    
    public NumberInWords(String value, Rules rules) {
        this.value = new BigDecimal(value);
        this.rules = rules;
    }
    
    public NumberInWords(Number value, Rules rules) {
        this(value.toString(), rules);
    }
    
    public NumberInWords(Number value, Locale locale) {
        this(value.toString(), LocalesRulesRegistry.get(locale));
    }
    
    public NumberInWords(Number value) {
        this(value.toString(), LocalesRulesRegistry.getDefaultRules());
    }
    
    public NumberInWords(String value) {
        this(new BigDecimal(value), LocalesRulesRegistry.getDefaultRules());
    }
    
    public NumberInWords(Double value, Rules rules) {
        this.value = BigDecimal.valueOf(value);
        this.rules = rules;
    }
    
    public NumberInWords(Double value) {
        this(value, LocalesRulesRegistry.getDefaultRules());
    }
    
    @Override
    public String toString() {
        return NumberToWordsConverter.getInstance().convert(value, rules, symbol, decimalPartToFraction);
    }
    
    public void setDecimalPartToFraction(boolean decimalPartToFraction) {
        this.decimalPartToFraction = decimalPartToFraction;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
