package com.amazon.luckiest;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] inputPhrases = {"once upon a midnight dreary", "say aaaaah for the dentist","lima is in peru","three blind mice see how they run"};
		LuckiestPhrase luckPhrases = new LuckiestPhrase(inputPhrases);
		luckPhrases.luckiestPhrases();
		System.out.println(inputPhrases[luckPhrases.getLuckiestPos()]);
		System.out.println(inputPhrases[luckPhrases.getSecLuckiestPos()]);
		
	}
}
