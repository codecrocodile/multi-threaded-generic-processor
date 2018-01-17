/*
 * @(#)Worker.java			27 Jan 2014
 */
package com.codecrocodile.generic;

/**
 * @author Chris Hatton
 */
public interface Worker<V, W> {
	W processPart(V part);
}
