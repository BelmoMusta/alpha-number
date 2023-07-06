package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestFrenchCases {
    
    @Test
    public void testParts() {
        Number x = 192345009;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("cent quatre-vingt-douze millions trois cent quarante-cinq mille neuf",
                numberInWords.toString());
    }
    
    @Test
    public void test1() {
        double x = 9878;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("neuf mille huit cent soixante-dix-huit", numberInWords.toString());
        
    }
    
    @Test
    public void test2() {
        double x = 102878;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("cent deux mille huit cent soixante-dix-huit", numberInWords.toString());
        
    }
    
    @Test
    public void test3() {
        double x = 400_000_005;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("quatre cents millions cinq", numberInWords.toString());
        
    }
    
    @Test
    public void test73() {
        double x = 73;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("soixante-treize", numberInWords.toString());
        
    }
    
    @Test
    public void test21() {
        double x = 21;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("vingt et un", numberInWords.toString());
    }
    
    @Test
    public void test4() {
        double x = 0;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("zéro", numberInWords.toString());
    }
    
    @Test
    public void test5() {
        double x = 1;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("un", numberInWords.toString());
    }
    
    @Test
    public void test6() {
        double x = 1111;
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("mille cent onze", numberInWords.toString());
    }
    
    @Test
    public void testDecimals() {
        double value = 200.0098;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("deux cents virgule zéro zéro quatre-vingt-dix-huit", numberInWords.toString());
    }
    
    @Test
    public void testNumber2() {
        double value = 2;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("deux", numberInWords.toString());
    }
    
    @Test
    public void testNumber3000() {
        double value = 3000;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("trois mille", numberInWords.toString());
        
    }
    
    @Test
    public void testNumber715() {
        double value = 715;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("sept cent quinze", numberInWords.toString());
    }
    @Test
    public void testCentInPlural() {
        double value = 800;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("huit cents", numberInWords.toString());
    }
    @Test
    public void testCentInPlural2() {
        double value = 1500;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("mille cinq cents", numberInWords.toString());
    }
    
    @Test
    public void testNumber0() {
        double value = 400_099_999_900_003L;
        NumberInWords numberInWords = new NumberInWords(value, Locale.FRENCH);
        Assert.assertEquals("quatre cents billions quatre-vingt-dix-neuf milliards neuf cent quatre-vingt-dix-neuf millions neuf cents mille trois", numberInWords.toString());
    }
    
}
