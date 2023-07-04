import com.mustabelmo.alphacurrency.LetteredNumber;
import org.junit.Assert;
import org.junit.Test;

public class EnglishTestCases {
	
	@Test
	public void testParts() {
		Number x = 192345009;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("one hundred ninety two million, three hundred forty five thousand, nine",
				letteredNumber.toString());
	}
	
	@Test
	public void test1() {
		double x = 9878;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("nine thousand, eight hundred seventy eight", letteredNumber.toString());
	}
	
	@Test
	public void test2() {
		double x = 102878;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("one hundred two thousand, eight hundred seventy eight", letteredNumber.toString());
	}
	
	@Test
	public void test3() {
		double x = 400_000_005;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("four hundred million, five", letteredNumber.toString());
	}
	
	@Test
	public void test73() {
		double x = 73;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("seventy three", letteredNumber.toString());
	}
	
	@Test
	public void test21() {
		double x = 21;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("twenty one", letteredNumber.toString());
	}
	
	@Test
	public void test4() {
		double x = 0;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("zero", letteredNumber.toString());
	}
	
	@Test
	public void test5() {
		double x = 1;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("one", letteredNumber.toString());
	}
	
	@Test
	public void test6() {
		double x = 1111;
		LetteredNumber letteredNumber = new LetteredNumber(x);
		Assert.assertEquals("one thousand, one hundred eleven", letteredNumber.toString());
	}
	
	@Test
	public void testDecimals() {
		double value = 200.0098;
		LetteredNumber letteredNumber = new LetteredNumber(value);
		Assert.assertEquals("two hundred and zero zero ninety eight", letteredNumber.toString());
	}
	
	@Test
	public void testNumber2() {
		double value = 2;
		LetteredNumber letteredNumber = new LetteredNumber(value);
		Assert.assertEquals("two", letteredNumber.toString());
	}
	
	@Test
	public void testNumber3000() {
		double value = 3000;
		LetteredNumber letteredNumber = new LetteredNumber(value);
		Assert.assertEquals("three thousand", letteredNumber.toString());
	}
	
	@Test
	public void testNumber715() {
		double value = 715;
		LetteredNumber letteredNumber = new LetteredNumber(value);
		Assert.assertEquals("seven hundred fifteen", letteredNumber.toString());
	}
	
}
