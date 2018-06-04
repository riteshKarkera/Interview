package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Indicating a minute of a day for a berlin clock,The two rows of lamps at the
 * bottom count the minutes. The first of these rows has 11 lamps, the second 4.
 * In the first row every lamp represents 5 minutes. In this first row the 3rd,
 * 6th and 9th lamp are red and indicate the first quarter, half and last
 * quarter of an hour. The other lamps are yellow. In the last row with 4 lamps
 * every lamp represents 1 minute.
 * 
 * @author Ritesh
 *
 */
public class Minute implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(Minute.class);
	private static final String FIVE_MINUTE_LAMP = "OOOOOOOOOOO";
	private static final String MINUTE_LAMP = "OOOO";

	@Override
	public String convertTime(String aTime) {
		try {
			int minute = Integer.parseInt(aTime);

			int modulasOfFive = minute % 5;
			int divisibleOfFive = minute / 5;
			if (modulasOfFive == 0) {
				return calculateFiveMinuteLamp(minute, divisibleOfFive, modulasOfFive) + "\nOOOO";
			} else {
				return calculateFiveMinuteLamp(minute, divisibleOfFive, modulasOfFive) + "\n"
						+ calculateMinuteLamp(minute, divisibleOfFive, modulasOfFive);
			}

		} catch (NumberFormatException ne) {
			LOG.error("Not a Number");
		}

		return "OOOOOOOOOOO\nOOOO";
	}

	private String calculateFiveMinuteLamp(int minute, int divisibleOfFive, int modulasOfFive) {
		if (minute < 5 && modulasOfFive == 1) {
			return FIVE_MINUTE_LAMP;
		}
		StringBuilder str = new StringBuilder(FIVE_MINUTE_LAMP);
		for (int i = 0; i < divisibleOfFive; i++) {
			if ((i + 1) * 5 % 3 == 0) {
				str.replace(i, i + 1, "R");
			} else {
				str.replace(i, i + 1, "Y");
			}

		}
		return str.toString();
	}

	private String calculateMinuteLamp(int minute, int divisibleOfFive, int modulasOfFive) {

		StringBuilder str = new StringBuilder(MINUTE_LAMP);
		for (int i = 0; i < modulasOfFive; i++) {
			str.replace(i, i + 1, "Y");
		}
		return str.toString();

	}
}
