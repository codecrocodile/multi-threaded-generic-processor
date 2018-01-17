/*
 * @(#)WordSplitter.java			27 Jan 2014
 */
package com.codecrocodile.impl;

import java.util.logging.Logger;

import com.codecrocodile.generic.Splitter;

/**
 * @author Chris Hatton
 */
public class WordSplitter implements Splitter<String, String> {
	
	public static final Logger log = Logger.getLogger(WordSplitter.class.getName());

	/* 
	 * @see com.codecrocodile.generic.Splitter#split(java.lang.Object)
	 */
    @Override
    public String[] split(String arg) {
    	log.info("Entering String[] split(String arg)");
    	
	    return arg.split(" ");
    }

}
