package com.mustabelmo.alphacurrency;

public class FrenchProviderImpl extends Provider {
	private String[] ones = {
			"zéro",
			"un",
			"deux",
			"trois",
			"quatre",
			"cinq",
			"six",
			"sept",
			"huit",
			"neuf"
	};
	private String[] tens = {
			"dix",
			"onze",
			"douze",
			"treize",
			"quatorze",
			"quinze",
			"seize",
			"dix-sept",
			"dix-huit",
			"dix-neuf",
	};
	
	private String[] multiplesOfTen = {
			"",
			"dix",
			"vingt",
			"trente",
			"quarante",
			"cinquante",
			"soixante",
			"soixante-dix",
			"quatre-vingt",
			"quatre-vingt-dix"};
	
	private String[] units = {
			"",
			"mille", //3
			"million", //6
			"milliard", //9
			"billion",//12
			"billiard",//15
			"trillion",//18
			"trilliard",//21
			"quadrillion",//24
			"quadrilliard",//27
			"quintillion",//30
			"quintilliard",//33
			"sextillion",//36
			"sextilliard",//39
			"septillion",//42
			"septilliard",//45
			"octillion",//48
			"octilliard",//51
			"nonillion",//54
			"nonilliard",//57
			"décillion",//60
			"décilliard",//63
	};
	
	@Override
	public String getHundreds(int hundredsDigit) {
		if (hundredsDigit == 1) {
			return "cent";
		}
		return ones[hundredsDigit];
	}
	
	@Override
	public String getUnitString(int unit) {
		if(unit>=units.length){
			return "10^"+3*unit;
		}
		return units[unit];
	}
	
	@Override
	public String getOne(int unitsDigit) {
		return ones[unitsDigit];
	}
	
	@Override
	public String getMultipleOfTen(int tensDigit) {
		return multiplesOfTen[tensDigit];
	}
	
	@Override
	public String getTen(int unitsDigit) {
		return tens[unitsDigit];
	}
	
	@Override
	public String getDecimalConnector() {
		return " virgule ";
	}
	
	@Override
	public String getHundredName() {
		return "cent";
	}
	
	@Override
	public boolean onesComeAfterTens() {
		return true;
	}
	
	@Override
	public boolean isSpecialCaseFor1() {
		return true;
	}
	
	@Override
	public boolean isInRangeOfSpecialCases(int onesDigit, int tensDigit) {
		if (onesDigit == 1 && tensDigit >=2) return true;
		return onesDigit > 1 && (tensDigit >= 7);
	}
	
	@Override
	public String getSpecialCases(int onesDigit, int tensDigit) {
		String separator;
		if (onesDigit == 1) {
			separator = " et ";
		} else {
			separator = getSeparator();
		}
		if (tensDigit == 7 || tensDigit == 9) {
			return multiplesOfTen[tensDigit - 1] + separator + tens[onesDigit];
		}
		return multiplesOfTen[tensDigit] + separator + ones[onesDigit];
	}
	
	@Override
	public String getZero() {
		return ones[0];
	}
}
