package com.mustabelmo.alphacurrency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Belmokhtar on 25/10/2017.
 */
public class AlphaNumber extends Number {
	public static final String SPACE = " ";
	public static final long THOUSAND = 1000L;
	public static final int HUNDRED = 100;
	public static final int ONE = 1;
	public static final int ZERO = 0;
	public static final int THREE = 3;
	
	private Number value;
	private String unit;
	private boolean decimalPartToLetters;
	
	public AlphaNumber() {
		decimalPartToLetters = true;
	}
	
	public AlphaNumber(Number value) {
		this();
		this.value = value;
	}
	
	public AlphaNumber(Number value, String unit) {
		this(value);
		this.unit = unit;
	}
	
	
	/**
	 * Gets the letter format of the number value.
	 *
	 * @return String
	 */
	public String toLetters() {
		BigDecimal bigDecimal = BigDecimal.valueOf(value.doubleValue());
		bigDecimal = bigDecimal.setScale(Utils.NB_DECIMALS, RoundingMode.FLOOR)
				.stripTrailingZeros();
		
		NumberFormat instance = NumberFormat.getInstance(Locale.FRANCE);
		instance.setGroupingUsed(false);
		String number = instance.
				format(bigDecimal);
		String[] split = number.split("\\.");
		String intValue = split[ZERO];
		String decimalValue = String.valueOf(ZERO);
		
		if (split.length > ONE) {
			decimalValue = split[ONE];
		}
		
		StringBuilder sb = new StringBuilder(convertValue(intValue));
		if (unit != null && !unit.isEmpty()) {
			sb.append(unit).append(SPACE);
		}
		
		long decVal = Long.parseLong(decimalValue);
		if (decVal != ZERO) {
			String decimalPart;
			if (decimalPartToLetters) {
				decimalPart = convertValue(decimalValue);
			} else {
				decimalPart = String.valueOf(decVal);
			}
			
			sb.append(Utils.COMA)
					.append(decimalPart);
		}
		return sb.toString();
	}
	
	/**
	 * Converts the given integer value value to letters.
	 *
	 * @param intValue the integer value.
	 * @return StringBuilder of the equivalent value in letters.
	 */
	private String convertValue(String intValue) {
		final StringBuilder stringBuilder = new StringBuilder();
		int intPart = Integer.parseInt(intValue);
		int range = ZERO;
		if (intPart <= 1) {
			stringBuilder.append(Utils.getAlpha(intPart));
		} else
			while (intPart != ZERO) {
				long remainder = intPart % THOUSAND;
				if (remainder != ZERO) {
					String space = "";
					
					if (range > ZERO && remainder != 1) {
						space = SPACE;
					}
					
					stringBuilder.insert(ZERO, convert(remainder, range)
							+ space + Utils.getUnitAtRange(range) + SPACE);
				}
				
				intPart /= THOUSAND;
				range += THREE;
			}
		return stringBuilder.toString().trim();
	}
	
	/**
	 * Converts a an integer value less than 1000 to letters.
	 *
	 * @param number the value to convert.
	 * @return String.
	 */
	private String convert(long number, int range) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		int result = (int) (number / HUNDRED);
		int remainder = (int) (number % HUNDRED);
		
		if (result == ONE) {
			stringBuilder.append(Utils.CENT)
					.append(SPACE);
		} else if (result != ZERO) {
			stringBuilder.append(Utils.getAlphaFor(result))
					.append(SPACE)
					.append(Utils.CENT)
					.append(SPACE);
		}
		if (number != 1 || range > 3 || remainder != 1) {
			stringBuilder.append(Utils.getAlphaFor(remainder))
                    .append(" ");
		}
		return stringBuilder.toString();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("{\n")
				.append("value : ")
				.append(value)
				.append(",\n")
				.append("letters: ")
				.append(toLetters())
				.append("\n}")
				.toString();
	}
	
	@Override
	public int intValue() {
		return value.intValue();
	}
	
	@Override
	public long longValue() {
		return value.longValue();
	}
	
	@Override
	public float floatValue() {
		return value.floatValue();
	}
	
	@Override
	public double doubleValue() {
		return value.doubleValue();
	}
}

