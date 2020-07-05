package com.mustabelmo.alphacurrency;

public class NumberPart {
	private String unit;
	
	private int wahadat;
	private int acharat;
	private int miaat;
	
	public NumberPart(int number, String unit) {
		this.unit = unit;
		wahadat = (number % 100) % 10;
		acharat = (number % 100) / 10;
		miaat = number / 100;
		
	}
	
	@Override
	public String toString() {
		return "NumberPart{" +
				"unit='" + unit + '\'' +
				", wahadat=" + Utils.getAlphaFor(wahadat) +
				", acharat=" + Utils.getAlphaFor(acharat) +
				", miaat=" + Utils.getAlphaFor(miaat) +
				'}';
	}
	
	public static void main(String[] args) {
		NumberPart numberPart = new NumberPart(213, "");
		System.out.println(numberPart);
	}
}
