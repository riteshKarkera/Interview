package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockTest {

	/**
	 * Scenario when Time passed is not in a proper format.
	 */
	@Test
	public void getBerlinLampsWhenTimeisNotInCorrectFormat() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("20180203073000"), "TimeStamp passed is not in a correct format HH:mm:ss");
	}

	/**
	 * Scenario when time passed is not in a range in an 24 hour range.
	 */
	@Test
	public void getBerlinLampsWhenTimeisNotInTheRange() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("25:61:61"), "TimeStamp passed is not 24 hrs range");
	}

	/**
	 * Scenario: Midnight When the time is 00:00:00
	 */
	@Test
	public void getBerlinLampsforMidNight() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("00:00:00"), "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO");
	}

	/**
	 * Scenario: Middle of the afternoon When the time is 13:17:01
	 */
	@Test
	public void getBerlinLampsforMiddleOfAfterNoon() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("13:17:01"), "O\nRROO\nRRRO\nYYROOOOOOOO\nYYOO");
	}

	/**
	 * Scenario: Just before midnight When the time is 23:59:59
	 */
	@Test
	public void getBerlinLampsJustBeforeMidNight() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("23:59:59"), "O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY");
	}

	/**
	 * Scenario: Midnight When the time is 24:00:00
	 * 
	 */
	@Test
	public void getBerlinLampsforExactMidNight() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("24:00:00"), "Y\nRRRR\nRRRR\nOOOOOOOOOOO\nOOOO");
	}

}
