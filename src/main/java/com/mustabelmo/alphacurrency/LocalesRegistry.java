package com.mustabelmo.alphacurrency;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocalesRegistry {
	private static final Map<Locale, Provider> MAP = new HashMap<>();
	private static final Provider DEFAULT_PROVIDER = new EnglishProviderImpl();
	
	static {
		register(Locale.FRENCH, new FrenchProviderImpl());
		register(Locale.ENGLISH, new EnglishProviderImpl());
		register(Locale.forLanguageTag("ar"), new ArabicProviderImpl());
	}
	
	public static Provider get(Locale key) {
		Locale effectiveKey = key;
		if (key != null && !MAP.containsKey(key)) {
			effectiveKey = Locale.forLanguageTag(key.getLanguage());
		}
		return MAP.getOrDefault(effectiveKey, DEFAULT_PROVIDER);
	}
	
	public static void register(Locale locale, Provider provider) {
		MAP.putIfAbsent(locale, provider);
	}
}
