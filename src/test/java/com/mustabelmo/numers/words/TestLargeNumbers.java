package com.mustabelmo.numers.words;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

public class TestLargeNumbers {
	
	@Test
	public void testParts() {
		Number x = new BigInteger("93539573680439696830496390192345009");
		NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
		Assert.assertEquals("quatre-vingt treize quintilliard, cinq cent trente neuf quintillion, cinq cent soixante treize quadrilliard, six cent quatre-vingt quadrillion, quatre cent trente neuf trilliard, six cent quatre-vingt seize trillion, huit cent trente billiard, quatre cent quatre-vingt seize billion, trois cent quatre-vingt-dix milliard, cent quatre-vingt douze million, trois cent quarante cinq mille, neuf",
				numberInWords.toString());
	}
	@Test
	public void testParts2() {
		Number x = new BigInteger("12345678900987654321012345678900987654321012345678900987654321012345");
		NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
		Assert.assertEquals("douze 10^66, trois cent quarante cinq décilliard, six cent soixante dix-huit décillion, neuf cent nonilliard, neuf cent quatre-vingt sept nonillion, six cent cinquante quatre octilliard, trois cent vingt et un octillion, douze septilliard, trois cent quarante cinq septillion, six cent soixante dix-huit sextilliard, neuf cent sextillion, neuf cent quatre-vingt sept quintilliard, six cent cinquante quatre quintillion, trois cent vingt et un quadrilliard, douze quadrillion, trois cent quarante cinq trilliard, six cent soixante dix-huit trillion, neuf cent billiard, neuf cent quatre-vingt sept billion, six cent cinquante quatre milliard, trois cent vingt et un million, douze mille, trois cent quarante cinq",
				numberInWords.toString());
	}
	@Test
	public void testParts2Eng() {
		Number x = new BigInteger("12345678900987654321012345678900987654321012345678900987654321012345");
		NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
		Assert.assertEquals("twelve unvigintillion, three hundred forty five vigintillion, six hundred seventy eight novemdecillion, nine hundred octodecillion, nine hundred eighty seven septendecillion, six hundred fifty four sexdecillion, three hundred twenty one quindecillion, twelve quattuordecillion, three hundred forty five tredecillion, six hundred seventy eight duodecillion, nine hundred undecillion, nine hundred eighty seven decillion, six hundred fifty four nonillion, three hundred twenty one octillion, twelve septillion, three hundred forty five sextillion, six hundred seventy eight quintillion, nine hundred quadrillion, nine hundred eighty seven trillion, six hundred fifty four billion, three hundred twenty one million, twelve thousand, three hundred forty five",
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
		Number x = new BigInteger("12345678900987654321012345678900987654321012345678900987654321012345");
		NumberInWords numberInWords = new NumberInWords(x, Locale.forLanguageTag("ar"));
		Assert.assertEquals("إثنا عشر أوكتودشيليونا وثلاثمائة وخمسة وأربعون سبتندشيليونا وستمائة وثمانية وسبعون سكسدشيليونا وتسعمائة كويندشيليون وتسعمائة وسبعة وثمانون كواتوردشيليونا وستمائة وأربعة وخمسون تريدشيليونا وثلاثمائة وواحد وعشرون دودشيليون وإثنا عشر أوندشيلليونا وثلاثمائة وخمسة وأربعون ديسيلليونا وستمائة وثمانية وسبعون نونيلليونا وتسعمائة أوكتيليون وتسعمائة وسبعة وثمانون سبتيلليونا وستمائة وأربعة وخمسون سكستليونا وثلاثمائة وواحد وعشرون كوينتليون وإثنا عشر كوادريليونا وثلاثمائة وخمسة وأربعون تريليارا وستمائة وثمانية وسبعون تريليونا وتسعمائة بليار وتسعمائة وسبعة وثمانون بليونا وستمائة وأربعة وخمسون مليارا وثلاثمائة وواحد وعشرون مليون وإثنا عشر ألفا وثلاثمائة وخمسة وأربعون",
				numberInWords.toString());
	}
	
	@Test
	public void testLargeNumbersWithDecimals() {
		String x = "1000000000000000.001";
		NumberInWords numberInWords = new NumberInWords(x);
		String toLetters = numberInWords.toLetters();
		Assert.assertEquals("one quadrillion and zero zero one", toLetters);
	}
	
}
