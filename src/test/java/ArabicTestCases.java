import com.mustabelmo.alphacurrency.LetteredNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class ArabicTestCases {
	Locale arabic = new Locale("ar");
	
	@Test
	public void testParts() {
		Number x = 192345009;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("مائة واثنان وتسعون مليونا وثلاثمائة وخمسة وأربعون ألفا وتسعة", letteredNumber.toString());
	}
	
	@Test
	public void test1() {
		double x = 9878;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("تسعة آلاف وثمانمائة وثمانية وسبعون", letteredNumber.toString());
		
	}
	
	@Test
	public void test2() {
		double x = 102878;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("مائة واثنان ألفا وثمانمائة وثمانية وسبعون", letteredNumber.toString());
		
	}
	
	@Test
	public void test3() {
		double x = 400_000_005;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("أربعمائة مليون وخمسة", letteredNumber.toString());
	}
	
	@Test
	public void test73() {
		double x = 73;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("ثلاثة وسبعون", letteredNumber.toString());
	}
	
	
	@Test
	public void test4() {
		double x = 0;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("صفر", letteredNumber.toString());
		
	}
	
	@Test
	public void test5() {
		double x = 1;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("واحد", letteredNumber.toString());
		
	}
	
	@Test
	public void test6() {
		double x = 1111;
		LetteredNumber letteredNumber = new LetteredNumber(x, arabic);
		Assert.assertEquals("ألف ومائة وإحدى عشر", letteredNumber.toString());
		
	}
	
	
	@Test
	public void test200() {
		LetteredNumber letteredNumber = new LetteredNumber(200, arabic);
		Assert.assertEquals("مائتان", letteredNumber.toString());
	}
	
	@Test
	public void testDecimals() {
		double value = 200.0098;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("مائتان فاصل صفر صفر ثمانية وتسعون", letteredNumber.toString());
	}
	
	@Test
	public void testNumber3000() {
		double value = 3000;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("ثلاثة آلاف", letteredNumber.toString());
	}
	
	@Test
	public void testNumber715() {
		double value = 715;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("سبعمائة وخمسة عشر", letteredNumber.toString());
		
	}
	
	@Test
	public void testNumber23000() {
		double value = 1000005.0000099;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("مليون وخمسة فاصل صفر صفر صفر صفر صفر تسعة وتسعون", letteredNumber.toString());
	}
	@Test
	public void testNumber2() {
		double value = 2;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("اثنان", letteredNumber.toString());
	}
	
	@Test
	public void testNumber410_000() {
		double value = 410_000;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("أربعمائة وعشرة آلاف", letteredNumber.toString());
	}
	@Test
	public void testNumber503_000() {
		double value = 503_000;
		LetteredNumber letteredNumber = new LetteredNumber(value, arabic);
		Assert.assertEquals("خمسمائة وثلاثة آلاف", letteredNumber.toString());
	}
}
