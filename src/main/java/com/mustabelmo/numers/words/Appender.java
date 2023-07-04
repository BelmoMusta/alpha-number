package com.mustabelmo.numers.words;

public class Appender {
	private final StringBuilder stringBuilder = new StringBuilder();
	
	public Appender append(Object obj) {
		stringBuilder.append(obj);
		return this;
	}
	
	public boolean isEmpty() {
		return stringBuilder.length() == 0;
	}
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}
