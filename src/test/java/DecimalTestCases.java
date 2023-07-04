import com.mustabelmo.alphacurrency.LetteredNumber;
import com.mustabelmo.alphacurrency.LetteredNumber;
import com.mustabelmo.alphacurrency.LetteredNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class DecimalTestCases {
	
	public static final Locale AR = Locale.forLanguageTag("ar");
	
	@Test
	public void testDecimalFrench() {
		Number x = 1.03423;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		String toLetters = letteredNumber.toLetters();
		Assert.assertEquals("un virgule zéro trois mille, quatre cent vingt trois", toLetters);
	}
	@Test
	public void testDecimalFrench2() {
		Number x = 1.0003423;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		String toLetters = letteredNumber.toLetters();
		Assert.assertEquals("un virgule zéro zéro zéro trois mille, quatre cent vingt trois", toLetters);
	}
	@Test
	public void testDecimalEnglish() {
		Number x = 1.03423;
		LetteredNumber letteredNumber = new LetteredNumber(x,Locale.ENGLISH);
		String toLetters = letteredNumber.toLetters();
		Assert.assertEquals("one and zero three thousand, four hundred twenty three", toLetters);
	}
	@Test
	public void testDecimalEnglish2() {
		Number x = 1.0003423;
		LetteredNumber letteredNumber = new LetteredNumber(x,Locale.ENGLISH);
		String toLetters = letteredNumber.toLetters();
		Assert.assertEquals("one and zero zero zero three thousand, four hundred twenty three", toLetters);
	}
	
	@Test
	public void testDecimalArab() {
		Number x = 13.073;
		LetteredNumber letteredNumber = new LetteredNumber(x, AR);
		String toLetters = letteredNumber.toLetters();
		Assert.assertEquals("ثلاثة عشر فاصل صفر ثلاثة وسبعون", toLetters);
	}
	
}
