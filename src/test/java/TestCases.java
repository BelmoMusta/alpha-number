import com.mustabelmo.alphacurrency.AlphaNumber;
import org.junit.Test;

public class TestCases {
	
	@Test
	public void alphanumberCase01() {
		for (int i = 0; i < 1; i++) {
			
			AlphaNumber alphaNumber;
			alphaNumber = new AlphaNumber(1000005);
			System.out.println(alphaNumber.toLetters());
			alphaNumber = new AlphaNumber(104);
			System.out.println(alphaNumber.toLetters());
			alphaNumber = new AlphaNumber(801);
			System.out.println(alphaNumber.toLetters());
			
		}
		
	}
}
