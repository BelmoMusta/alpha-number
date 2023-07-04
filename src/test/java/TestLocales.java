import com.mustabelmo.alphacurrency.EnglishProviderImpl;
import com.mustabelmo.alphacurrency.FrenchProviderImpl;
import com.mustabelmo.alphacurrency.LocalesRegistry;
import com.mustabelmo.alphacurrency.Provider;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class TestLocales {
	@Test
	public void testLocal() {
		LocalesRegistry.register(Locale.FRANCE, new FrenchProviderImpl());
		Provider def = LocalesRegistry.get(null);
		Assert.assertTrue(def instanceof EnglishProviderImpl);
		Provider provider = LocalesRegistry.get(Locale.CANADA_FRENCH);
		Assert.assertTrue(provider instanceof FrenchProviderImpl);
		Assert.assertEquals("", provider.getDoubledUnitString(0));
		Assert.assertEquals("", provider.getPluralUnitString(0));
		Assert.assertEquals("", def.getSpecialCases(0,0));
		Assert.assertEquals("", def.getAccusativeUnitString(0));
		Assert.assertEquals("10^303", def.getUnitString(101));
		Provider arabic = LocalesRegistry.get(Locale.forLanguageTag("ar"));
		String pluralUnitString = arabic.getPluralUnitString(100);
		Assert.assertEquals("10^300", pluralUnitString);
		String plurals = arabic.getPluralUnitString(4);
		Assert.assertEquals("بليونات", plurals);
		String doubledUnitString = arabic.getDoubledUnitString(2);
		Assert.assertEquals("مليونان", doubledUnitString);
	}
}
