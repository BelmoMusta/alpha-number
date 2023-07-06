package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestDecimalCases {
    
    public static final Locale AR = Locale.forLanguageTag("ar");
    
    @Test
    public void testDecimalFrench() {
        Number x = 1.03423;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("un virgule zéro trois mille quatre cent vingt-trois", toLetters);
    }
    
    @Test
    public void testDecimalFrench2() {
        Number x = 1.0003423;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("un virgule zéro zéro zéro trois mille quatre cent vingt-trois", toLetters);
    }
    
    @Test
    public void testDecimalEnglish() {
        Number x = 1.03423;
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("one and zero three thousand, four hundred twenty three", toLetters);
    }
    
    @Test
    public void testDecimalEnglish2() {
        Number x = 1.0003423;
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("one and zero zero zero three thousand, four hundred twenty three", toLetters);
    }
    
    @Test
    public void testDecimalArab() {
        Number x = 13.073;
        NumberInWords numberInWords = new NumberInWords(x, AR);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("ثلاثة عشر فاصل صفر ثلاثة وسبعون", toLetters);
    }
    
    @Test
    public void testDecimalArabWithFraction() {
        Number x = 13.073;
        NumberInWords numberInWords = new NumberInWords(x, AR);
        numberInWords.setDecimalPartToFraction(true);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("ثلاثة عشر و 73/1000", toLetters);
    }
    
    @Test
    public void testDecimalFrenchWithFraction() {
        Number x = 13.073;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        numberInWords.setDecimalPartToFraction(true);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("treize et 73/1000", toLetters);
    }
    
    @Test
    public void testDecimalEnglishDecimalPartToFraction() {
        Number x = 134.232;
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        numberInWords.setDecimalPartToFraction(true);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("one hundred thirty four and 232/1000", toLetters);
    }
    
    @Test
    public void testZeroWithDecimalPart() {
        Number x = 0.01;
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("zero and zero one", toLetters);
    }
    
    @Test
    public void testZeroWithDecimalPart2() {
        Number x = 0.00123;
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("zero and zero zero one hundred twenty three", toLetters);
    }
    
    @Test
    public void testZeroWithDecimalPartFR() {
        Number x = 0.01;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("zéro virgule zéro un", toLetters);
    }
    
    @Test
    public void testZeroWithDecimalPartAR() {
        Number x = 0.01;
        NumberInWords numberInWords = new NumberInWords(x, AR);
        String toLetters = numberInWords.toLetters();
        Assert.assertEquals("صفر فاصل صفر واحد", toLetters);
    }
    
}
