package net.sf.memoranda;

import java.util.Date;
import java.util.Timer;
import java.util.Calendar;
import java.util.Vector;

public class TimeProgRecord {

	/*We need to dynamically allocate the dates
	 * or whatever data we decide needs to be put in these vectors*/
    static int Vector _progress = new Vector();
    static Vector _dates = new Vector();

    /*
     * Following the style of EventsScheduler.java
     * we will store the dates in attributes under the Date class
     * if we need to
     **/
	Date prevDate;
	Date currentDate;
	
	/*accumTime will be the accumulated amount of time 
	 * between the current date and the previous date
	 *this will be the total while currentTime
	 *will serve as the placeholder attribute for the amount of time
	 *between the last updated progress and the current entry.
	 *prevTimeinMilli is necessary because that calculation between the two
	 *intervals of time must be done and milliseconds before it is converted into 
	 *hours days and minutes*/
	int accumTime;
	long prevTimeinMilli;
	long currentTimeinMilli;
	
	//The string that will be outputed to the Agenda Frame
	String progString;
	
	//Constructor
	TimeProgRecord(TaskImpl task){
		currentTimeinMilli = System.currentTimeMillis();
		calcTime();
		_progress.addElement(task.getProgress());
	}
	
	/*
	 *Method will calculate the amount of time between prevDate and currentDate,
	 *add that time to accumTime,
	 *then return that time in a string that can be appended to the progress string
	 **/
	public void calcTime(){
		
		private static final int SECOND = 1000;
		private static final int MINUTE = 60 * SECOND;
		private static final int HOUR = 60 * MINUTE;
		private static final int DAY = 24 * HOUR;
		
		progString.append("You have made " + task.getProgress() + " progress in, ");
		
		//Give Previous time the former Current Time and set Current Time to the new SystemTime
		prevTimeinMilli = currentTimeinMilli;
		currentTimeinMilli = System.currentTimeMillis();
		
		//Calculate how many Days Hours and Minutes are in the difference of dates
		long milliDifference = currenTimeinMilli - prevTimeInMilli;

		if (milliDifference > DAY) {
		  progString.append(milliDifference / DAY).append(" days ");
		  milliDifference %= DAY;
		}
		if (milliDifference > HOUR) {
		  progString.append(milliDifference / HOUR).append(" hours ");
		  milliDifference %= HOUR;
		}
		if (milliDifference > MINUTE) {
		  progString.append(milliDifference / MINUTE).append(" minutes ");
		  milliDifference %= MINUTE;
		}
		if (milliDifference > SECOND) {
		  progString.append(milliDifference / SECOND).append(" seconds ");
		  milliDifference %= SECOND;
		}
		
		acuumTime += milliDifference;
	}
}
