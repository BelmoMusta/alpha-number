package com.mustabelmo.numers.words;

import java.math.BigDecimal;

public interface INumberToWordsConverter {
    String convert(BigDecimal number, Rules rules, String symbol, boolean decimalPartToFraction);
    
    default String convert(String number, Rules rules, String symbol, boolean decimalPartToFraction) {
        return convert(new BigDecimal(number), rules, symbol, decimalPartToFraction);
    }
    
    
}
