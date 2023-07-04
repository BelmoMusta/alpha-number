package com.mustabelmo.numers.words;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocalesRulesRegistry {
	private static final Map<Locale, Rules> MAP = new HashMap<>();
	private static final Rules DEFAULT_RULES = new EnglishRulesImpl();
	
	static {
		register(Locale.FRENCH, new FrenchRulesImpl());
		register(Locale.ENGLISH, new EnglishRulesImpl());
		register(Locale.forLanguageTag("ar"), new ArabicRulesImpl());
	}
	
	public static Rules get(Locale key) {
		Locale effectiveKey = key;
		if (key != null && !MAP.containsKey(key)) {
			effectiveKey = Locale.forLanguageTag(key.getLanguage());
		}
		return MAP.getOrDefault(effectiveKey, DEFAULT_RULES);
	}
	
	public static void register(Locale locale, Rules rules) {
		MAP.putIfAbsent(locale, rules);
	}
}
