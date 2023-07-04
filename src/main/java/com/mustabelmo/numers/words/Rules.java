package com.mustabelmo.numers.words;

public abstract class Rules {
	
	public abstract String getHundreds(int hundredsDigit);
	
	public abstract String getUnitString(int unit);
	public  String getDoubledUnitString(int unit){
		return "";
	}
	public  String getPluralUnitString(int unit){
		return getUnitString(unit);
	}
	
	public abstract String getOne(int unitsDigit);
	
	public abstract String getMultipleOfTen(int tensDigit);
	
	public abstract String getTen(int unitsDigit);
	
	public abstract String getDecimalConnector();
	
	public abstract String getHundredName();
	
	public String getSeparator() {
		return " ";
	}
	
	public String getHundredSeparator() {
		return " ";
	}
	
	public abstract boolean onesComeAfterTens();
	
	public String getUnitsSeparator() {
		return ", ";
	}
	
	public boolean isSpecialCaseFor1() {
		return false;
	}
	
	public boolean isSpecialCaseFor2() {
		return false;
	}
	
	
	public boolean isInRangeOfPlurals(int number) {
		return false;
	}
	
	public boolean isInRangeOfSpecialCases(int onesDigit, int tensDigit) {
		return false;
	}
	
	public String getSpecialCases(int onesDigit, int tensDigit) {
		return "";
	}
	
	public abstract String getZero();
	
	public boolean shouldUnitBeAccusative(int number) {
		return false;
	}
	public String getAccusativeUnitString(int unit) {
		return "";
	}
	public abstract String getJunction();
}
