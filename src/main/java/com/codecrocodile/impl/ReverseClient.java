/*
 * @(#)Client.java			27 Jan 2014
 */
package com.codecrocodile.impl;

import java.util.logging.Logger;

import com.codecrocodile.generic.GenericProcessor;
import com.codecrocodile.generic.Processor;

/**
 * @author Chris Hatton
 */
public class ReverseClient {
	
	public static final Logger log = Logger.getLogger(ReverseClient.class.getName());
	
	public String reverseWordsInSentance(String sentance) {
		log.info("Entering String reverseWordsInSentance(String sentance)");
		
		log.info("Sentance to reverse words of = " + sentance);
		
		WordSplitter wordSplitter = new WordSplitter();
		WordAggregator wordAggregator = new WordAggregator();
		Processor<String, String> genericProcessor = 
				new GenericProcessor<String, String, String, String>(wordSplitter, wordAggregator, ReverseWorker.class, String.class);
		
		String reversedSentanceWords = genericProcessor.process(sentance);
		
		log.info("Sentance words reversed = " + reversedSentanceWords);
		
		return reversedSentanceWords;
	}

}
