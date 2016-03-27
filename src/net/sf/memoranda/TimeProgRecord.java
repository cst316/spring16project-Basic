package net.sf.memoranda;

import java.util.Date;
import java.util.Timer;
import java.util.Calendar;
import java.util.Vector;

public class TimeProgRecord {

	/*We need to dynamically allocate the dates
	 * or whatever data we decide needs to be put in these vectors*/
    static Vector _progress = new Vector();
    static Vector _Dates = new Vector();

    /*
     * Following the style of EventsScheduler.java
     * we will store the dates in attributes under the Date class
     **/
	Date prevDate;
	Date currentDate;
	
	/*accumTime will be the accumulated amount of time 
	 * between the current date and the previous date
	 *this will be the total while currentTime
	 *will serve as the placeholder attribute for the amount of time
	 *between the last updated progress and the current entry*/
	int accumTime;
	int currentTime;
	
	//The string that will be outputed to the Agenda Frame
	String progString;
	
	//Constructor
	TimeProgRecord(){
		
	}
	
	/*
	 *Method will calculate the amount of time between prevDate and currentDate,
	 *add that time to accumTime,
	 *then return that time in currentTime
	 **/
	public int calcTime(Date prevDate, currentDate);
}
