package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestNumbersToWordsConverter {
    @Test
    public void testLocal() {
        LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
        Rules frenchRules = LocalesRulesRegistry.get(Locale.FRANCE);
        INumberToWordsConverter numbersToWordsConverter = new NumberToWordsConverter();
        String numberInWords = numbersToWordsConverter.convert("1500", frenchRules);
        String numberInWordsWithSymbol = numbersToWordsConverter.convert("1500", frenchRules, null, false);
        System.out.println(numberInWords);
        Assert.assertEquals("mille cinq cents", numberInWords.toString());
    }
    @Test
    public void testConversionWithSymbol() {
        LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
        Rules frenchRules = LocalesRulesRegistry.get(Locale.FRANCE);
        INumberToWordsConverter numbersToWordsConverter = new NumberToWordsConverter();
         String numberInWordsWithSymbol = numbersToWordsConverter.convert("1500", frenchRules, "$", false);
        Assert.assertEquals("mille cinq cents $", numberInWordsWithSymbol.toString());
    }
    @Test
    public void run() {
        Rules arabicRules = LocalesRulesRegistry.get(Locale.forLanguageTag("ar"));
        INumberToWordsConverter numbersToWordsConverter = new NumberToWordsConverter();
        for (long i = 0; i < 9_000_000_0L; i+=10_000_0L) {
            String numberInWordsWithSymbol = numbersToWordsConverter.convert(i+"", arabicRules);
            System.out.println(i+" "+ numberInWordsWithSymbol);
        }
    }
}
