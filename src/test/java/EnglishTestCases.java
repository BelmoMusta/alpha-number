import com.mustabelmo.alphacurrency.NumberInWords;
import org.junit.Assert;
import org.junit.Test;

public class EnglishTestCases {
	
	@Test
	public void testParts() {
		Number x = 192345009;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("one hundred ninety two million, three hundred forty five thousand, nine",
				numberInWords.toString());
	}
	
	@Test
	public void test1() {
		double x = 9878;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("nine thousand, eight hundred seventy eight", numberInWords.toString());
	}
	
	@Test
	public void test2() {
		double x = 102878;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("one hundred two thousand, eight hundred seventy eight", numberInWords.toString());
	}
	
	@Test
	public void test3() {
		double x = 400_000_005;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("four hundred million, five", numberInWords.toString());
	}
	
	@Test
	public void test73() {
		double x = 73;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("seventy three", numberInWords.toString());
	}
	
	@Test
	public void test21() {
		double x = 21;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("twenty one", numberInWords.toString());
	}
	
	@Test
	public void test4() {
		double x = 0;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("zero", numberInWords.toString());
	}
	
	@Test
	public void test5() {
		double x = 1;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("one", numberInWords.toString());
	}
	
	@Test
	public void test6() {
		double x = 1111;
		NumberInWords numberInWords = new NumberInWords(x);
		Assert.assertEquals("one thousand, one hundred eleven", numberInWords.toString());
	}
	
	@Test
	public void testDecimals() {
		double value = 200.0098;
		NumberInWords numberInWords = new NumberInWords(value);
		Assert.assertEquals("two hundred and zero zero ninety eight", numberInWords.toString());
	}
	
	@Test
	public void testNumber2() {
		double value = 2;
		NumberInWords numberInWords = new NumberInWords(value);
		Assert.assertEquals("two", numberInWords.toString());
	}
	
	@Test
	public void testNumber3000() {
		double value = 3000;
		NumberInWords numberInWords = new NumberInWords(value);
		Assert.assertEquals("three thousand", numberInWords.toString());
	}
	
	@Test
	public void testNumber715() {
		double value = 715;
		NumberInWords numberInWords = new NumberInWords(value);
		Assert.assertEquals("seven hundred fifteen", numberInWords.toString());
	}
	
}
