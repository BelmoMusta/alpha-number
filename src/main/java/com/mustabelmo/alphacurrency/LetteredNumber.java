package com.mustabelmo.alphacurrency;

import java.util.Locale;

public class LetteredNumber extends AbstractLetteredNumber {
	
	public LetteredNumber(Number value, Locale locale) {
		super(value, LocalesRegistry.get(locale));
	}
	public LetteredNumber(Number value) {
		this(value, Locale.ENGLISH);
	}
	
	@Override
	public String toString() {
		return super.toLetters();
	}
}
