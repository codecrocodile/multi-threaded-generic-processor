/*
 * @(#)ReverseClientTest.java			27 Jan 2014
 *
 * Copyright (c) 2012-2014 Groovy Fly.
 * 3 Aillort place, East Mains, East Kilbride, Scotland.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Groovy 
 * Fly. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Groovy Fly.
 */
package com.codecrocodile.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris Hatton
 */
public class ReverseClientTest {
	
	
	@Test
	public void testReverseWordsInSentance() {
		ReverseClient reverseClient = new ReverseClient();
		String result = reverseClient.reverseWordsInSentance("This is the sentance I want the words reversed in");
		
		Assert.assertEquals("sihT si eht ecnatnes I tnaw eht sdrow desrever ni", result);
	}

}
