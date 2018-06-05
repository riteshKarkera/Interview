package com.ubs.opsit.interviews;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *  
 *  The Berlin Clock representation.
 *   
 *  
 *  
 * @author Ritesh
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClock {
	private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);
	private Seconds second;
	private Hour hour;
	private Minute minute;

	BerlinClock(Seconds second, Hour hour, Minute minute) {
		this.second = second;
		this.hour = hour;
		this.minute = minute;
	}

	private static boolean isTimeFormatValid(String inputString) {
		SimpleDateFormat format = new java.text.SimpleDateFormat("HH:mm:ss");
		try {
			format.parse(inputString);
			LOG.debug("Returns true as the time is valid");
			return true;
		} catch (ParseException e) {
			LOG.debug("Returns false as time is invalid");
			return false;
		}
	}

	/**
	 * gets the berlin lamps for the time passed in HH:MM:SS format
	 * 
	 * @param aTime
	 * @return the berlin lamp representation where R represents Red, Y represents
	 *         Yellow, O represents the lamp is OFF.
	 */
	public String getBerlinLamps(String aTime) {
		if (isTimeFormatValid(aTime)) {
			String[] time = aTime.split(":");
			String hours = time[0];
			String minutes = time[1];
			String seconds = time[2];
			if (checkIfTimeIsValid(hours, minutes, seconds)) {
				return second.convertTime(seconds) + "\n" + hour.convertTime(hours) + "\n"
						+ minute.convertTime(minutes);
			} else {
				return "TimeStamp passed is not 24 hrs range";
			}
		}
		return "TimeStamp passed is not in a correct format HH:mm:ss";
	}

	private boolean checkIfTimeIsValid(String hours, String minutes, String seconds) {
		int hour = Integer.parseInt(hours);
		int minute = Integer.parseInt(minutes);
		int second = Integer.parseInt(seconds);
		if (minute <= 60 && minute >= 0 && second <= 60 && second >= 0 && hour <= 24 && hour >= 0) {
			LOG.debug("Time passed is within the range");
			return true;
		}
		LOG.debug("Time passed is not within the range");
		return false;

	}

	public static void main(String[] args) {

		BerlinClock berlinclock = new BerlinClock(new Seconds(), new Hour(), new Minute());
		System.out.println(berlinclock.getBerlinLamps("24:00:00"));
	}

}
