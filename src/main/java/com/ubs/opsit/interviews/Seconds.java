package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Indicating a seconds of a day for a berlin clock. the top of the clock there
 * is a yellow lamp that blinks on/off every two seconds.
 * 
 * @author Ritesh
 *
 */
public class Seconds implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(Seconds.class);

	@Override
	public String convertTime(String aTime) {

		return calculateSecondLamps(aTime);
	}

	private String calculateSecondLamps(String aTime) {
		int seconds = 0;
		try {
			seconds = Integer.parseInt(aTime);
			if (seconds != 0) {
				LOG.info("Seconds is not equals to Zero");
				if (seconds % 2 == 0) {
					LOG.info("Seconds is modulas of Two");
					LOG.info("Turning ON the Lamp");
					return "Y";
				}
			}
		} catch (NumberFormatException ne) {
			LOG.error(ne.toString());
		}
		LOG.info("Turning OFF the Lamp");
		return "O";
	}

}
