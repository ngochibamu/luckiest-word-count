package com.amazon.luckiest;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LuckiestPhraseTest{
	
	private static final Logger logger = Logger.getLogger(LuckiestPhraseTest.class.getName());
	
	
	@Test
	public void emptyPhraseTest(){
		String[] inputPhrases = {" "};
		LuckiestPhrase luckPhrase = new LuckiestPhrase(inputPhrases);
		assertEquals("must output 0",0,luckPhrase.getPhraseLuckCount(inputPhrases[0]));
	}
	
	@Test
	public void getPhraseLuckCountTest(){
		String[] inputPhrases = {"acegi moqs xwv tuvceikm"};
		LuckiestPhrase luckPhrase = new LuckiestPhrase(inputPhrases);
		assertEquals("must output 3",3,luckPhrase.getPhraseLuckCount(inputPhrases[0]));
	}
	/**
	 * Successfully test that "three blind mice see how they run" is the second luckiest 
	 */
	@Test
	public void secondLuckiestPhraseTest(){
		String[] inputPhrases = {"say aaaaah for the dentist", "three blind mice see how they run", "once upon a midnight dreary"};
		LuckiestPhrase luckPhrase = new LuckiestPhrase(inputPhrases);
		assertEquals("three blind mice see how they run", inputPhrases[luckPhrase.luckiestPhrases().getSecLuckiestPos()]);
	}
	
	/**
	 * This test successfully test if the phrase "say aaaaah ieig for the dentist" is the second luckiest
	 */
	@Test
	public void secondLuckiestPhrase2Test(){
		String[] inputPhrases = {"lima is in yyyyy yyyyyy yyyyyy yyyyyy yyyyyy peru", "three blind mice see how they run","once upon a midnight dreary","say aaaaah ieig for the dentist"};
		LuckiestPhrase luckPhrase = new LuckiestPhrase(inputPhrases);
		assertEquals("Second Luckiest Phrase","say aaaaah ieig for the dentist", inputPhrases[luckPhrase.luckiestPhrases().getSecLuckiestPos()]);
	}
}
