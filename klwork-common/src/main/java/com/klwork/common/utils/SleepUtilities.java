package com.klwork.common.utils;

/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 */

public class SleepUtilities
{
	/**
	 * Nap between zero and NAP_TIME seconds.
	 */
	public static void nap() {
		nap(NAP_TIME);
	}

	/**
	 * Nap between zero and duration seconds.
	 */
	public static void nap(int duration) {
        	int sleeptime = (int) (duration * Math.random() );
        	try { Thread.sleep(sleeptime*1000); }
        	catch (InterruptedException e) {}
	}

	private static final int NAP_TIME = 5;
}
