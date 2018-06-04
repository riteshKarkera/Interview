package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * Testing Seconds.java
 * 
 * @author Ritesh
 *
 */

public class SecondsTest {
	/**
	 * converting time to lamps when seconds is passed is not the Number.
	 * 
	 */
	@Test
	public void convertTimeWhenHourIsNotNumber() {
		Seconds sec = new Seconds();
		assertEquals(sec.convertTime("ABCD"), "O");
	}

	/**
	 * 
	 * converting time to lamps when seconds passed is modulus of two.
	 */
	@Test
	public void convertTimeWhenSecondsIsModulasOfTwo() {
		Seconds sec = new Seconds();
		assertEquals(sec.convertTime("44"), "Y");
	}

	/**
	 * 
	 * converting time to lamps when seconds passed is not the modulus of two.
	 */
	@Test
	public void convertTimeWhenSecondsIsNotModulasOfTwo() {
		Seconds sec = new Seconds();
		assertEquals(sec.convertTime("45"), "O");
	}

}
