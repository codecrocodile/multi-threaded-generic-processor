/*
 * @(#)Splitter.java			27 Jan 2014
 */
package com.codecrocodile.generic;

/**
 * @author Chris Hatton
 */
public interface Splitter<T, V> {
	V[] split(T arg);
}
