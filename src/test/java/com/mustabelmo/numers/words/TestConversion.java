package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestConversion {
    @Test
    public void testConversion() {
        NumberInWords numberInWords = new NumberInWords(169.79);
        Assert.assertEquals("one hundred sixty nine and seventy nine", numberInWords.toLetters());
        numberInWords = numberInWords.convertTo(Locale.FRENCH);
        Assert.assertEquals("cent soixante neuf virgule soixante dix-neuf", numberInWords.toLetters());
    }
    
    @Test
    public void testNumberWithSymbol() {
        LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
        NumberInWords numberInWords = new NumberInWords(169.79);
        numberInWords.setSymbol("$");
        Assert.assertEquals("one hundred sixty nine and seventy nine $", numberInWords.toLetters());
        
    }
    
    @Test
    public void testNumberWithSymbolEmpty() {
        NumberInWords numberInWords = new NumberInWords(169.79);
        numberInWords.setSymbol("");
        Assert.assertEquals("one hundred sixty nine and seventy nine", numberInWords.toLetters());
        
    }
    
    @Test
    public void testNumberWithSymbolInArabic() {
        NumberInWords numberInWords = new NumberInWords(169.79, Locale.forLanguageTag("ar"));
        numberInWords.setSymbol("$");
        
        Assert.assertEquals("مائة وتسعة وستون فاصل تسعة وسبعون $", numberInWords.toLetters());
    }
}
