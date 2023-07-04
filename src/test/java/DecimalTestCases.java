import com.mustabelmo.alphacurrency.NumberInWords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class DecimalTestCases {
	
	public static final Locale AR = Locale.forLanguageTag("ar");
	
	@Test
	public void testDecimalFrench() {
		Number x = 1.03423;
		NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
		String toLetters = numberInWords.toLetters();
		Assert.assertEquals("un virgule zéro trois mille, quatre cent vingt trois", toLetters);
	}
	@Test
	public void testDecimalFrench2() {
		Number x = 1.0003423;
		NumberInWords numberInWords = new NumberInWords(x, Locale.FRENCH);
		String toLetters = numberInWords.toLetters();
		Assert.assertEquals("un virgule zéro zéro zéro trois mille, quatre cent vingt trois", toLetters);
	}
	@Test
	public void testDecimalEnglish() {
		Number x = 1.03423;
		NumberInWords numberInWords = new NumberInWords(x,Locale.ENGLISH);
		String toLetters = numberInWords.toLetters();
		Assert.assertEquals("one and zero three thousand, four hundred twenty three", toLetters);
	}
	@Test
	public void testDecimalEnglish2() {
		Number x = 1.0003423;
		NumberInWords numberInWords = new NumberInWords(x,Locale.ENGLISH);
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
	public void testDecimalEnglishDecimalPartToFraction() {
		Number x = 134.232;
		NumberInWords numberInWords = new NumberInWords(x,Locale.ENGLISH);
		numberInWords.setDecimalPartToFraction(true);
		String toLetters = numberInWords.toLetters();
		Assert.assertEquals("one hundred thirty four and 232/1000", toLetters);
	}
	
}
