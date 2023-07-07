package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Locale;

public class TestLargeNumbers {
    
    @Test
    public void testParts() {
        Number x = new BigInteger("93539573680439696830496390192345009");
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("quatre-vingt-treize quintilliards cinq cent trente-neuf " +
                        "quintillions cinq cent soixante-treize quadrilliards six cent " +
                        "quatre-vingt quadrillions quatre cent trente-neuf trilliards " +
                        "six cent quatre-vingt-seize trillions huit cent trente billiards " +
                        "quatre cent quatre-vingt-seize billions trois cent " +
                        "quatre-vingt-dix milliards cent quatre-vingt-douze millions trois cent " +
                        "quarante-cinq mille neuf",
                numberInWords.toString());
    }
    
    @Test
    public void testParts2() {
        Number x = new BigInteger(
                "12345678900987654321012345678900987654321012345678900987654321012345");
        NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
        Assert.assertEquals("douze 10^66 trois cent quarante-cinq décilliards six cent soixante-dix-huit décillions " +
                        "neuf cents nonilliards neuf cent quatre-vingt-sept nonillions six cent cinquante-quatre " +
                        "octilliards trois cent vingt et un octillion douze septilliards trois cent quarante-cinq " +
                        "septillions six cent soixante-dix-huit sextilliards neuf cents sextillions neuf cent " +
                        "quatre-vingt-sept quintilliards six cent cinquante-quatre quintillions trois cent vingt et " +
                        "un quadrilliard douze quadrillions trois cent quarante-cinq trilliards six cent " +
                        "soixante-dix-huit trillions neuf cents billiards neuf cent quatre-vingt-sept billions six " +
                        "cent cinquante-quatre milliards trois cent vingt et un million douze mille trois cent " +
                        "quarante-cinq",
                numberInWords.toString());
    }
    
    @Test
    public void testParts2Eng() {
        Number x = new BigInteger(
                "12345678900987654321012345678900987654321012345678900987654321012345");
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        Assert.assertEquals("twelve unvigintillion, three hundred forty five vigintillion, six hundred seventy eight " +
                        "novemdecillion, nine hundred octodecillion, nine hundred eighty seven septendecillion, six " +
                        "hundred fifty four sexdecillion, three hundred twenty one quindecillion, twelve " +
                        "quattuordecillion, three hundred forty five tredecillion, six hundred seventy eight " +
                        "duodecillion, nine hundred undecillion, nine hundred eighty seven decillion, six hundred " +
                        "fifty four nonillion, three hundred twenty one octillion, twelve septillion, three hundred " +
                        "forty five sextillion, six hundred seventy eight quintillion, nine hundred quadrillion, nine" +
                        " hundred eighty seven trillion, six hundred fifty four billion, three hundred twenty one " +
                        "million, twelve thousand, three hundred forty five",
                numberInWords.toString());
    }
    
    @Test
    public void testParts3Eng() {
        Number x = new BigInteger("10").pow(128);
        NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
        Assert.assertEquals("one hundred unquadragintillion",
                numberInWords.toString());
    }
    
    @Test
    public void testPartsArabic() {
        Number x = new BigInteger(
                "12345678900987654321012345678900987654321012345678900987654321012345");
        NumberInWords numberInWords = new NumberInWords(x, Locale.forLanguageTag("ar"));
        Assert.assertEquals("إثنا عشر أوكتودشيليونا وثلاثمائة وخمسة وأربعون سبتندشيليونا وستمائة وثمانية وسبعون " +
                        "سكسدشيليونا وتسعمائة كويندشيليون وتسعمائة وسبعة وثمانون كواتوردشيليونا وستمائة وأربعة وخمسون" +
                        " تريدشيليونا وثلاثمائة وواحد وعشرون دودشيليون وإثنا عشر أوندشيلليونا وثلاثمائة وخمسة وأربعون" +
                        " ديسيلليونا وستمائة وثمانية وسبعون نونيلليونا وتسعمائة أوكتيليون وتسعمائة وسبعة وثمانون " +
                        "سبتيلليونا وستمائة وأربعة وخمسون سكستليونا وثلاثمائة وواحد وعشرون كوينتليون وإثنا عشر " +
                        "كوادريليونا وثلاثمائة وخمسة وأربعون تريليارا وستمائة وثمانية وسبعون تريليونا وتسعمائة بليار " +
                        "وتسعمائة وسبعة وثمانون بليونا وستمائة وأربعة وخمسون مليارا وثلاثمائة وواحد وعشرون مليون " +
                        "وإثنا عشر ألفا وثلاثمائة وخمسة وأربعون",
                numberInWords.toString());
    }
    
    @Test
    public void testLargeNumbersWithDecimals() {
        String x = "1000000000000000.001";
        NumberInWords numberInWords = new NumberInWords(x);
        String toLetters = numberInWords.toString();
        Assert.assertEquals("one quadrillion and zero zero one", toLetters);
    }
    
}
