import com.mustabelmo.alphacurrency.FrenchRulesImpl;
import com.mustabelmo.alphacurrency.LocalesRulesRegistry;
import com.mustabelmo.alphacurrency.NumberInWords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestConversion {
	@Test
	public void testConversion() {
		LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
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
		numberInWords.setDecimalPartToFraction(true);
		Assert.assertEquals("one hundred sixty nine and 79/100 $", numberInWords.toLetters());
		Assert.assertEquals("cent soixante neuf et 79/100 $", numberInWords.convertTo(Locale.FRENCH).toLetters());
		Assert.assertEquals("مائة وتسعة وستون و 79/100 $", numberInWords.convertTo(Locale.forLanguageTag("ar")).toLetters());
		
	}
}
