package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Testing Minute.java
 * 
 * @author Ritesh
 *
 */

public class MinuteTest {

	/**
	 * converting time to lamps when minutes passed is not the Number.
	 */
	@Test
	public void convertTimeWhenMinuteIsNotANumber() {
		Minute min = new Minute();
		assertEquals(min.convertTime("ABCD"), "OOOOOOOOOOO\nOOOO");

	}

	/**
	 * 
	 * converting time to lamps when minute passed is modulus of five.
	 */
	@Test
	public void convertTimeWhenMinuteIsModualsOfFive() {
		Minute min = new Minute();
		assertEquals(min.convertTime("10"), "YYOOOOOOOOO\nOOOO");
	}

	/**
	 * 
	 * converting time to lamps when minutes passed is not the modulus of five.
	 */
	@Test
	public void convertTimeWhenMinuteIsNotModualsOfFive() {
		Minute min = new Minute();
		assertEquals(min.convertTime("12"), "YYOOOOOOOOO\nYYOO");
	}

	/**
	 * 
	 * converting time to lamps to check the first, quarter and last of hour.
	 */
	@Test
	public void convertTimeIndicatingFirstQuarterAndLastOfHour() {
		Minute min = new Minute();
		assertEquals(min.convertTime("47"), "YYRYYRYYROO\nYYOO");
	}

}
