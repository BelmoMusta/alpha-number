import com.mustabelmo.alphacurrency.LetteredNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class FrenchTestCases {
	
	@Test
	public void testParts() {
		Number x = 192345009;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("cent quatre-vingt douze million, trois cent quarante cinq mille, neuf",
				letteredNumber.toString());
	}
	
	@Test
	public void test1() {
		double x = 9878;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("neuf mille, huit cent soixante dix-huit", letteredNumber.toString());
		
	}
	
	@Test
	public void test2() {
		double x = 102878;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("cent deux mille, huit cent soixante dix-huit", letteredNumber.toString());
		
	}
	
	@Test
	public void test3() {
		double x = 400_000_005;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("quatre cent million, cinq", letteredNumber.toString());
		
	}
	
	@Test
	public void test73() {
		double x = 73;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("soixante treize", letteredNumber.toString());
		
	}
	
	@Test
	public void test21() {
		double x = 21;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("vingt et un", letteredNumber.toString());
	}
	
	@Test
	public void test4() {
		double x = 0;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("zéro", letteredNumber.toString());
	}
	
	@Test
	public void test5() {
		double x = 1;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("un", letteredNumber.toString());
	}
	
	@Test
	public void test6() {
		double x = 1111;
		LetteredNumber letteredNumber = new LetteredNumber(x, Locale.FRENCH);
		Assert.assertEquals("mille, cent onze", letteredNumber.toString());
	}
	
	@Test
	public void testDecimals() {
		double value = 200.0098;
		LetteredNumber letteredNumber = new LetteredNumber(value, Locale.FRENCH);
		Assert.assertEquals("deux cent virgule zéro zéro quatre-vingt dix-huit", letteredNumber.toString());
	}
	
	@Test
	public void testNumber2() {
		double value = 2;
		LetteredNumber letteredNumber = new LetteredNumber(value, Locale.FRENCH);
		Assert.assertEquals("deux", letteredNumber.toString());
	}
	
	@Test
	public void testNumber3000() {
		double value = 3000;
		LetteredNumber letteredNumber = new LetteredNumber(value, Locale.FRENCH);
		Assert.assertEquals("trois mille", letteredNumber.toString());
		
	}
	
	@Test
	public void testNumber715() {
		double value = 715;
		LetteredNumber letteredNumber = new LetteredNumber(value, Locale.FRENCH);
		Assert.assertEquals("sept cent quinze", letteredNumber.toString());
	}
	
}
