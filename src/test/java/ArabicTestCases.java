import com.mustabelmo.alphacurrency.NumberInWords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class ArabicTestCases {
	Locale arabic = new Locale("ar");
	
	@Test
	public void testParts() {
		Number x = 192345009;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("مائة واثنان وتسعون مليونا وثلاثمائة وخمسة وأربعون ألفا وتسعة", numberInWords.toString());
	}
	
	@Test
	public void test1() {
		double x = 9878;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("تسعة آلاف وثمانمائة وثمانية وسبعون", numberInWords.toString());
		
	}
	
	@Test
	public void test2() {
		double x = 102878;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("مائة واثنان ألفا وثمانمائة وثمانية وسبعون", numberInWords.toString());
		
	}
	
	@Test
	public void test3() {
		double x = 400_000_005;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("أربعمائة مليون وخمسة", numberInWords.toString());
	}
	
	@Test
	public void test73() {
		double x = 73;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("ثلاثة وسبعون", numberInWords.toString());
	}
	
	
	@Test
	public void test4() {
		double x = 0;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("صفر", numberInWords.toString());
		
	}
	
	@Test
	public void test5() {
		double x = 1;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("واحد", numberInWords.toString());
		
	}
	
	@Test
	public void test6() {
		double x = 1111;
		NumberInWords numberInWords = new NumberInWords(x, arabic);
		Assert.assertEquals("ألف ومائة وإحدى عشر", numberInWords.toString());
		
	}
	
	
	@Test
	public void test200() {
		NumberInWords numberInWords = new NumberInWords(200, arabic);
		Assert.assertEquals("مائتان", numberInWords.toString());
	}
	
	@Test
	public void testDecimals() {
		double value = 200.0098;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("مائتان فاصل صفر صفر ثمانية وتسعون", numberInWords.toString());
	}
	
	@Test
	public void testNumber3000() {
		double value = 3000;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("ثلاثة آلاف", numberInWords.toString());
	}
	
	@Test
	public void testNumber715() {
		double value = 715;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("سبعمائة وخمسة عشر", numberInWords.toString());
		
	}
	
	@Test
	public void testNumber23000() {
		double value = 1000005.0000099;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("مليون وخمسة فاصل صفر صفر صفر صفر صفر تسعة وتسعون", numberInWords.toString());
	}
	@Test
	public void testNumber2() {
		double value = 2;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("اثنان", numberInWords.toString());
	}
	
	@Test
	public void testNumber410_000() {
		double value = 410_000;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("أربعمائة وعشرة آلاف", numberInWords.toString());
	}
	@Test
	public void testNumber503_000() {
		double value = 503_000;
		NumberInWords numberInWords = new NumberInWords(value, arabic);
		Assert.assertEquals("خمسمائة وثلاثة آلاف", numberInWords.toString());
	}
}
