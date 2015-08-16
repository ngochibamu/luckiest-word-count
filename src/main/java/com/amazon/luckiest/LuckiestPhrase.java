package com.amazon.luckiest;

import java.util.logging.Logger;

/**
 * 
 * Class LuckiestPhrase calculates the luck for each phrase in the input array, where
 * luck of a phrase is defined as the number of words within the phrase that have at least 4 letters within the following set: 
 * {a, c, e, g, i, k, m, .......,u, w, y}. Invoking the luckiestPhrases() method will print the luckiest 2 phrases.
 * @author dchibamu
 *
 */
public class LuckiestPhrase
{
	private static final Logger logger = Logger.getLogger(LuckiestPhrase.class.getName());
	private static final char LETTER_A = 'a';
	private static final int LUCK_WORD_LENGTH = 4;
	private String[] phrases;
	private int[] luckyCount;
	private int luckiestPos;
	private int secLuckiestPos;
	
	/**
	 * 	Finds the positions of the two luckiest sentences, by looping through the array of luck counts,
	 *  and checking on each loop if the luck count value at current position is greater than the last assigned 
	 *  luckiest position (luckiestPos), if so current position becomes the new position of the luckiest phrase.
	 *  Also checks if current luck count is greater than last stored second luckiest value but less than current luckiest value,
	 *  if so that becomes the new second luckiest position.
	 */
	public LuckiestPhrase luckiestPhrases(){
		if(phrases.length < 2){
			System.out.println("Input array must contain at least 2 phrases.");
			System.exit(0);
		}
		for(int i = 0; i < phrases.length; i++){
			luckyCount[i] = this.getPhraseLuckCount(phrases[i]);
		}
		luckiestPos = 0;
		secLuckiestPos = 1;
		if(luckyCount[luckiestPos] < luckyCount[secLuckiestPos]){
			luckiestPos = 1;
			secLuckiestPos = 0;
		}
		for(int i = 2;i < luckyCount.length; i++){
			if(luckyCount[i] > luckyCount[luckiestPos]){
				secLuckiestPos = luckiestPos;
				luckiestPos = i;
			}else if(luckyCount[i] == luckyCount[luckiestPos]){
				if(luckyCount[secLuckiestPos] != luckyCount[luckiestPos]){
					secLuckiestPos = i;
				}
			}else if(luckyCount[i] > luckyCount[secLuckiestPos]){
				secLuckiestPos = i;
			}
			//logger.info("i="+i+", secLuckiestPos="+secLuckiestPos+", luckiestPos="+luckiestPos);
		}
		return this;
	}
	/**
	 * Calculates the luck count for phrase
	 * 
	 * @param phrase
	 * @return int phraseLuckCount
	 */
	public int getPhraseLuckCount(String phrase){
		int phraseLuckCount = 0;
		int wordLuckCount = 0;
		phrase = phrase.trim();
		char[] phraseCharData = phrase.toCharArray();
		if(phrase.length() >= LUCK_WORD_LENGTH){
			for(int i = 0; i < phraseCharData.length; i++){
				//Ignore any characters not part of the set [a-z]
				if(!Character.isLetter(phraseCharData[i]) && !Character.isWhitespace(phraseCharData[i])){
					continue;
				}
				if(((int)phraseCharData[i] - (int)LETTER_A) % 2 == 0){
					wordLuckCount++;
				}				
				if(Character.isWhitespace(phraseCharData[i]) || i == phraseCharData.length - 1){
					if(wordLuckCount >= LUCK_WORD_LENGTH){
						phraseLuckCount++;						
					}
					wordLuckCount = 0;
				}
			}
		}
		return phraseLuckCount;
	}
	
	/**
	 * 
	 * @param inputPhrases the input phrase array
	 */
	public LuckiestPhrase(String[] inputPhrases){
		phrases = inputPhrases;
		luckyCount = new int[phrases.length];
		luckiestPos = 0;
		secLuckiestPos = 1;
	}
	
	/**
	 * @return the phrases
	 */
	public String[] getPhrases() {
		return phrases;
	}

	/**
	 * @param phrases the phrases to set
	 */
	public void setPhrases(String[] phrases) {
		this.phrases = phrases;
	}

	/**
	 * @return the luckiestPos
	 */
	public int getLuckiestPos() {
		return luckiestPos;
	}

	/**
	 * @param luckiestPos the luckiestPos to set
	 */
	public void setLuckiestPos(int luckiestPos) {
		this.luckiestPos = luckiestPos;
	}

	/**
	 * @return the secLuckiestPos
	 */
	public int getSecLuckiestPos() {
		return secLuckiestPos;
	}

	/**
	 * @param secLuckiestPos the secLuckiestPos to set
	 */
	public void setSecLuckiestPos(int secLuckiestPos) {
		this.secLuckiestPos = secLuckiestPos;
	}
}
