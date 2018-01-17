/*
 * @(#)Aggregator.java			27 Jan 2014
 */
package com.codecrocodile.generic;

/**
 * @author Chris Hatton
 */
public interface Aggregator<U, W> {
	U aggregate(W[] args);
}
