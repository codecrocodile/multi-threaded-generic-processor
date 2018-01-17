/*
 * @(#)WordAggregator.java			27 Jan 2014
 */
package com.codecrocodile.impl;

import java.util.logging.Logger;

import com.codecrocodile.generic.Aggregator;

/**
 * @author Chris Hatton
 */
public class WordAggregator implements Aggregator<String, String> {

	public static final Logger log = Logger.getLogger(WordAggregator.class.getName());
	
	/* 
	 * @see com.codecrocodile.generic.Aggregator#aggregate(W[])
	 */
    @Override
    public String aggregate(String[] args) {
    	log.info("Entering String aggregate(String[] args)");
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for (String s : args) {
    		sb.append(s);
    		sb.append(" ");
    	}
    	
    	return sb.toString();
    }

}
