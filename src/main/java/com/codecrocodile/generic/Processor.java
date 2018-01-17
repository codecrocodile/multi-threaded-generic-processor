/*
 * @(#)Processor.java			27 Jan 2014
 */
package com.codecrocodile.generic;

/**
 * @author Chris Hatton
 */
public interface Processor<T, U> {
	U process(T arg);
}
