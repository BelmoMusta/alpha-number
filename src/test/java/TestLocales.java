import com.mustabelmo.alphacurrency.EnglishRulesImpl;
import com.mustabelmo.alphacurrency.FrenchRulesImpl;
import com.mustabelmo.alphacurrency.LocalesRulesRegistry;
import com.mustabelmo.alphacurrency.Rules;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestLocales {
	@Test
	public void testLocal() {
		LocalesRulesRegistry.register(Locale.FRANCE, new FrenchRulesImpl());
		Rules def = LocalesRulesRegistry.get(null);
		Assert.assertTrue(def instanceof EnglishRulesImpl);
		Rules rules = LocalesRulesRegistry.get(Locale.CANADA_FRENCH);
		Assert.assertTrue(rules instanceof FrenchRulesImpl);
		Assert.assertEquals("", rules.getDoubledUnitString(0));
		Assert.assertEquals("", rules.getPluralUnitString(0));
		Assert.assertEquals("", def.getSpecialCases(0,0));
		Assert.assertEquals("", def.getAccusativeUnitString(0));
		Assert.assertEquals("10^303", def.getUnitString(101));
		Rules arabic = LocalesRulesRegistry.get(Locale.forLanguageTag("ar"));
		String pluralUnitString = arabic.getPluralUnitString(100);
		Assert.assertEquals("10^300", pluralUnitString);
		String plurals = arabic.getPluralUnitString(4);
		Assert.assertEquals("بليونات", plurals);
		String doubledUnitString = arabic.getDoubledUnitString(2);
		Assert.assertEquals("مليونان", doubledUnitString);
	}
}
