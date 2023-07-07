package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestNumbersToWordsConverter {
    @Test
    public void testLocal() {
        LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
        Rules def = LocalesRulesRegistry.get(Locale.FRANCE);
        INumberToWordsConverter numbersToWordsConverter = new NumberToWordsConverter();
        String numberInWords = numbersToWordsConverter.convert("1500", def, null, false);
        Assert.assertEquals("mille cinq cents", numberInWords.toString());
    }
}
