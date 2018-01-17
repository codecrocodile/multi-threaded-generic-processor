/*
 * @(#)ReverseWorker.java			27 Jan 2014
 */
package com.codecrocodile.impl;

import java.util.logging.Logger;

import com.codecrocodile.generic.Worker;

/**
 * @author Chris Hatton
 */
public class ReverseWorker implements Worker<String, String> {

	public static final Logger log = Logger.getLogger(ReverseWorker.class.getName());
	
	/* 
	 * @see com.codecrocodile.generic.Worker#processPart(java.lang.Object)
	 */
    @Override
    public String processPart(String part) {
    	log.info("Entering String processPart(String part)");
    	
	    StringBuffer sb = new StringBuffer(part);
    	return sb.reverse().toString();
    }

}
