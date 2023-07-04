package com.mustabelmo.alphacurrency;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class AbstractLetteredNumber {
	public static final BigDecimal TEN = BigDecimal.valueOf(10);
	protected final Provider provider;
	private final BigDecimal value;
	
	public AbstractLetteredNumber(String value, Provider provider) {
		this.value = new BigDecimal(value);
		this.provider = provider;
	}
	
	public AbstractLetteredNumber(Number value, Provider provider) {
		this(value.toString(), provider);
	}
	
	public String toLetters() {
		LinkedList<NumberPart> numberParts = getIntegerNumberParts(value);
		Appender sb = new Appender();
		String collect = numberParts.stream()
				.map(Object::toString)
				.collect(Collectors.joining(provider.getUnitsSeparator()));
		sb.append(collect);
		BigDecimal fractionalPart = value.remainder(BigDecimal.ONE);
		if (fractionalPart.compareTo(BigDecimal.ZERO) > 0) {
			sb.append(provider.getDecimalConnector());
			int numberOfDecimalPlaces = getNumberOfDecimalPlaces(value);
			BigDecimal pow = TEN.pow(numberOfDecimalPlaces);
			BigDecimal decimalPart = fractionalPart.multiply(pow);
			LinkedList<NumberPart> decimalParts = getIntegerNumberParts(decimalPart);
			String decimalPartAsLetters = decimalParts.stream()
					.map(Object::toString)
					.collect(Collectors.joining(provider.getUnitsSeparator()));
			int numberOfZerosAfterDecimalSymbol = getNumberOfZerosAfterDecimalSymbol(fractionalPart);
			String zeros = IntStream.range(0, numberOfZerosAfterDecimalSymbol)
					.mapToObj(i -> provider.getZero())
					.collect(Collectors.joining(" "));
			if (!zeros.isEmpty()) {
				sb.append(zeros);
				sb.append(' ');
			}
			sb.append(decimalPartAsLetters);
		}
		return sb.toString();
	}
	
	private int getNumberOfZerosAfterDecimalSymbol(BigDecimal fractionalPart) {
		BigDecimal temp = fractionalPart;
		int zeros = 0;
		while (temp.compareTo(BigDecimal.ONE) < 0) {
			temp = temp.multiply(TEN);
			zeros++;
		}
		
		return zeros - 1;
	}
	
	protected LinkedList<NumberPart> getIntegerNumberParts(BigDecimal value) {
		LinkedList<NumberPart> numberParts = new LinkedList<>();
		BigInteger bigIntegerValue = value.toBigInteger();
		BigInteger oneThousand = BigInteger.valueOf(1000L);
		int unit = 0;
		do {
			int modulo = bigIntegerValue.mod(oneThousand).intValue();
			NumberPart numberPart = new NumberPart(modulo);
			numberPart.setUnit(unit++);
			if (value.compareTo(BigDecimal.ZERO) == 0 || !numberPart.isEmpty()) {
				numberParts.addFirst(numberPart);
			}
			bigIntegerValue = bigIntegerValue.divide(oneThousand);
		} while (bigIntegerValue.compareTo(BigInteger.ZERO) != 0);
		return numberParts;
	}
	
	int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
		return Math.max(0, bigDecimal.stripTrailingZeros().scale());
	}
	
	private class NumberPart {
		private final int number;
		private int unit = -1;
		private final int onesDigit;
		private final int tensDigit;
		private final int hundredsDigit;
		
		public NumberPart(int number) {
			onesDigit = (number % 100) % 10;
			tensDigit = (number % 100) / 10;
			hundredsDigit = number / 100;
			this.number = number;
		}
		
		@Override
		public String toString() {
			Appender sb = new Appender();
			traitHundreds(sb);
			if (provider.isInRangeOfSpecialCases(onesDigit, tensDigit)) {
				if (!sb.isEmpty()) {
					sb.append(provider.getSeparator());
				}
				sb.append(provider.getSpecialCases(onesDigit, tensDigit));
			} else {
				if (provider.onesComeAfterTens()) {
					traitTens(sb);
					traitOnes(sb);
				} else {
					traitOnes(sb);
					traitTens(sb);
				}
			}
			traitUnits(sb);
			return sb.toString();
		}
		
		private void traitUnits(Appender sb) {
			if (unit != -1 && (onesDigit > 0 || tensDigit > 0 || hundredsDigit > 0)) {
				boolean spaceAsSeparator = false;
				String unitString;
				if (provider.isSpecialCaseFor1() && number % 10 == 1) {
					unitString = provider.getUnitString(unit);
				} else if (provider.isSpecialCaseFor2() && number == 2) {
					unitString = provider.getDoubledUnitString(unit);
				} else if (provider.isInRangeOfPlurals(number)) {
					spaceAsSeparator = true;
					unitString = provider.getPluralUnitString(unit);
				} else {
					if (provider.shouldUnitBeAccusative(number)) {
						unitString = provider.getAccusativeUnitString(unit);
					} else {
						unitString = provider.getUnitString(unit);
					}
				}
				if (!provider.isInRangeOfPlurals(number % 100)) {
					spaceAsSeparator = true;
				}
				if (spaceAsSeparator && !unitString.isEmpty() && !sb.isEmpty()) {
					sb.append(" ");
				}
				sb.append(unitString);
			}
		}
		
		private void traitOnes(Appender sb) {
			String ones = "";
			if (number == 1 && unit >= 1 && provider.isSpecialCaseFor1())
				return;
			if (number == 2 && unit >= 1 && provider.isSpecialCaseFor2())
				return;
			if ((onesDigit > 0 && (provider.isTensCombined() && tensDigit != 1))
					|| (hundredsDigit == 0 && tensDigit == 0 && unit == 0)) {
				ones = provider.getOne(onesDigit);
			}
			if (!sb.isEmpty() && !ones.isEmpty()) {
				sb.append(provider.getSeparator());
			}
			sb.append(ones);
		}
		
		private void traitTens(Appender sb) {
			
			String tens;
			if (provider.isTensCombined() && tensDigit == 1) {
				tens = provider.getTen(onesDigit);
			} else {
				tens = provider.getMultipleOfTen(tensDigit);
			}
			if (!sb.isEmpty() && !tens.isEmpty()) {
				sb.append(provider.getSeparator());
			}
			sb.append(tens);
		}
		
		private void traitHundreds(Appender sb) {
			if (hundredsDigit > 0) {
				sb.append(provider.getHundreds(hundredsDigit));
				if ((hundredsDigit != 1 || !provider.isSpecialCaseFor1())
						&& (hundredsDigit != 2 || !provider.isSpecialCaseFor2())) {
					sb.append(provider.getHundredSeparator())
							.append(provider.getHundredName());
				}
			}
		}
		
		public void setUnit(int unit) {
			this.unit = unit;
		}
		
		public boolean isEmpty() {
			return number == 0;
		}
	}
	
}
