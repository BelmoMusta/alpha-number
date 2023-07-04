package com.mustabelmo.alphacurrency;

public class ArabicRulesImpl extends Rules {
	String[] ones = {
			"صفر",
			"واحد",
			"اثنان",
			"ثلاثة",
			"أربعة",
			"خمسة",
			"ستة",
			"سبعة",
			"ثمانية",
			"تسعة"
	};
	String[] tens = {
			
			"عشرة",
			"إحدى عشر",
			"إثنا عشر",
			"ثلاثة عشر",
			"أربعة عشر",
			"خمسة عشر",
			"ستة عشر",
			"سبعة عشر",
			"ثمانية عشر",
			"تسعة عشر",
	};
	
	String[] multiplesOfTen = {
			"",
			"عشرة",
			"عشرون",
			"ثلاثون",
			"أربعون",
			"خمسون",
			"ستون",
			"سبعون",
			"ثمانون",
			"تسعون"};
	String[] hundreds = {
			"",
			"مائة",
			"مائتان",
			"ثلاث",
			"أربع",
			"خمس",
			"ست",
			"سبع",
			"ثمان",
			"تسع"
	};
	
	String[] singularUnits = {
			"",
			"ألف",
			"مليون",
			"مليار",
			"بليون",
			"بليار",
			"تريليون",
			"تريليار",
			"كوادريليون",
			"كوينتليون",
			"سكستليون",
			"سبتيلليون",
			"أوكتيليون",
			"نونيلليون",
			"ديسيلليون",
			"أوندشيلليون",
			"دودشيليون",
			"تريدشيليون",
			"كواتوردشيليون",
			"كويندشيليون",
			"سكسدشيليون",
			"سبتندشيليون",
			"أوكتودشيليون",
			"نوفمدشيليون",
			"فجنتليون",
	};
	String[] pluralUnits = {
			"",
			"آلاف",
			"ملايين",
			"ملايير"
	};
	
	@Override
	public String getHundreds(int hundredsDigit) {
		return hundreds[hundredsDigit];
	}
	
	@Override
	public String getUnitString(int unit) {
		return singularUnits[unit];
	}
	
	@Override
	public String getDoubledUnitString(int unit) {
		String singularUnit = singularUnits[unit];
		if (!singularUnit.isEmpty()) {
			return singularUnit +"ان";
		}
		
		return singularUnit;
	}
	
	@Override
	public String getPluralUnitString(int unit) {
		if(unit<=3) {
			return pluralUnits[unit];
		}
		if(singularUnits.length<=unit){
			return "10^" + unit *3;
		}
		return singularUnits[unit] +"ات";
	}
	
	@Override
	public boolean isInRangeOfPlurals(int number) {
		return number%100 >= 3 && number%100 <=10;
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
	public String getDecimalConnector() {
		return " فاصل ";
	}
	
	@Override
	public String getHundredName() {
		return "مائة";
	}
	
	@Override
	public String getSeparator() {
		return " و";
	}
	
	@Override
	public String getHundredSeparator() {
		return "";
	}
	
	@Override
	public boolean onesComeAfterTens() {
		return false;
	}
	
	@Override
	public String getUnitsSeparator() {
		return " و";
	}
	
	@Override
	public boolean isSpecialCaseFor1() {
		return true;
	}
	
	@Override
	public boolean isSpecialCaseFor2() {
		return true;
	}
	
	@Override
	public String getTen(int unitsDigit) {
		return tens[unitsDigit];
	}
	
	@Override
	public String getZero() {
		return ones[0];
	}
	
	@Override
	public boolean shouldUnitBeAccusative(int number) {
		int modulo = number % 100;
		return modulo != 0 && (modulo > 10 || modulo <3);
	}
	
	@Override
	public String getAccusativeUnitString(int unit) {
		String singularUnit = singularUnits[unit];
		if(unit>0) {
			return singularUnit + "ا";
		}
		return singularUnit;
	}
	
	@Override
	public String getJunction() {
		return " و ";
	}
}
