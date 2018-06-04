package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockTest {

	@Test
	public void getBerlinLampsWhenTimeisNotInCorrectFormat() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("20180203073000"), "TimeStamp passed is not in a correct format HH:mm:ss");
	}

	@Test
	public void getBerlinLampsWhenTimeisNotInTheRange() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("25:61:61"), "TimeStamp passed is not 24 hrs range");
	}

	@Test
	public void getBerlinLamps() {
		BerlinClock bcl = new BerlinClock(new Seconds(), new Hour(), new Minute());
		assertEquals(bcl.getBerlinLamps("10:41:44"), "Y\nRROO\nOOOO\nYYRYYRYYOOO\nYOOO");
	}

}
