package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing Hour.java
 * 
 * @author Ritesh
 *
 */

public class HourTest {

	/**
	 * 
	 * converting time to lamps when hour is passed is not the Number.
	 */
	@Test
	public void convertTimeWhenHourIsNotNumber() {
		Hour hour = new Hour();
		assertEquals(hour.convertTime("ABCD"), "OOOO\nOOOO");
	}

	/**
	 * 
	 * converting time to lamps when Hour passed is modulus of five.
	 */
	@Test
	public void convertTimeWhenHourIsModualsOfFive() {
		Hour hour = new Hour();
		assertEquals(hour.convertTime("10"), "RROO\nOOOO");
	}

	/**
	 * 
	 * converting time to lamps when hour passed is not the modulus of five.
	 */
	@Test
	public void convertTimeWhenHourIsNotModualsOfFive() {
		Hour hour = new Hour();
		assertEquals(hour.convertTime("12"), "RROO\nRROO");
	}

}
