package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indicating a hours of a day for a berlin clock ,The top two rows of lamps are
 * red. These indicate the hours of a day. In the top row there are 4 red lamps.
 * Every lamp represents 5 hours. In the lower row of red lamps every lamp
 * represents 1 hour.
 * 
 * @author Ritesh
 *
 */

public class Hour implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(Hour.class);
	private static final String FIVE_HOUR_LAMP = "OOOO";
	private static final String HOUR_LAMP = "OOOO";

	@Override
	public String convertTime(String aTime) {
		try {
			int hour = Integer.parseInt(aTime);
			int modulasOfFive = hour % 5;
			int divisibleOfFive = hour / 5;
			if (modulasOfFive == 0) {
				return calculateFiveHourLamps(hour, divisibleOfFive, modulasOfFive) + "\nOOOO";
			} else {
				return calculateFiveHourLamps(hour, divisibleOfFive, modulasOfFive) + "\n"
						+ calculateHourLamps(hour, divisibleOfFive, modulasOfFive);
			}

		} catch (NumberFormatException ne) {
			LOG.error("Not a Number...");
		}
		return "OOOO\nOOOO";
	}

	private String calculateHourLamps(int hour, int divisibleOfFive, int modulasOfFive) {
		StringBuilder str = new StringBuilder(HOUR_LAMP);
		for (int i = 0; i < modulasOfFive; i++) {
			str.replace(i, i + 1, "R");
		}
		return str.toString();
	}

	private String calculateFiveHourLamps(int hour, int divisibleOfFive, int modulasOfFive) {
		if (hour < 5 && modulasOfFive == 1) {
			return FIVE_HOUR_LAMP;
		}
		StringBuilder str = new StringBuilder(FIVE_HOUR_LAMP);
		for (int i = 0; i < divisibleOfFive; i++) {
			str.replace(i, i + 1, "R");
		}
		return str.toString();
	}

}
