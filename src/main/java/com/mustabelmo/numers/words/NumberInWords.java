package com.mustabelmo.numers.words;

import java.util.Locale;

public class NumberInWords extends AbstractNumberInWords {
	
	public NumberInWords(Number value, Locale locale) {
		this(value, LocalesRulesRegistry.get(locale));
	}
	
	public NumberInWords(String value, Locale locale) {
		super(value, LocalesRulesRegistry.get(locale));
	}
	public NumberInWords(String value) {
		this(value, Locale.ENGLISH);
	}
	
	public NumberInWords(Double value, Locale locale) {
		super(value, LocalesRulesRegistry.get(locale));
	}
	public NumberInWords(Number value, Rules rules) {
		super(value, rules);
	}
	public NumberInWords(Number value) {
		this(value, Locale.ENGLISH);
	}
	public NumberInWords convertTo(Locale anotherLocale) {
		NumberInWords numberInWords = new NumberInWords(getValue(), anotherLocale);
		numberInWords.setDecimalPartToFraction(this.decimalPartToFraction);
		numberInWords.setSymbol(this.symbol);
		return numberInWords;
	}
	
	@Override
	public String toString() {
		return super.toLetters();
	}
}
