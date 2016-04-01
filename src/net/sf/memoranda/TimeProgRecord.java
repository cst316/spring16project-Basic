package net.sf.memoranda;

import java.util.Date;
import java.util.Timer;
import java.util.Calendar;
import java.util.Vector;

public class TimeProgRecord {

	/*We need to dynamically allocate the dates
	 * or whatever data we decide needs to be put in these vectors*/
    static Vector<Integer> progress = new Vector<>();
    static Vector<TimeLength> times = new Vector<>();

    Task task;
	
	/*accumTime will be the accumulated amount of time 
	 * of all the effort put into that task
	 *currentTime will serve as the placeholder attribute for the current amount of time
	 *prevTimeinMilli is the attribute that holds the previous amount of time
	 **/
	
	private int progressCheck = task.getProgress();
	private long prevTimeinMilli;
	private long currentTimeinMilli;
	
	//This is a placeholder for effort in case multiple clicks are used to increment effort
	private int progressCumulative;
	
	//The string that will be outputed to the Agenda Frame
	private String progString;
	
	//Constructor
	public TimeProgRecord(Task task){
		this.task = task;
		currentTimeinMilli = System.currentTimeMillis();
		calcTime();
	}
	
	
	public int checkProgress(){
		return progressCheck;
	}
	
	/*
	 * Aaron Lajom's change:
	 * I converted this into a time converter that uses my class TimeLength.
	 * The idea is to call this whenever you add progress values and to see if
	 * the last change was done within minutes or less.
	 */
	public TimeLength calcTime(){
		
		String typeTime;
		int SECOND = 1000;
		int MINUTE = 60 * SECOND;
		int HOUR = 60 * MINUTE;
		int DAY = 24 * HOUR;
		
		//progString.append("You have made " + task.getProgress() + " progress in, ");
		
		//Give Previous time the former Current Time and set Current Time to the new SystemTime
		long prevTimeinMilli = currentTimeinMilli;
		long currentTimeinMilli = System.currentTimeMillis();
		
		//Calculate how many Days Hours and Minutes are in the difference of dates
		long milliDifference = currentTimeinMilli - prevTimeinMilli;

		if (milliDifference%DAY > 0) {
		  //progString.append(milliDifference / DAY).append(" days ");
		  milliDifference %= DAY;
		  typeTime = "Days";
		}
		if (milliDifference%HOUR > 0) {
		  //progString.append(milliDifference / HOUR).append(" hours ");
		  milliDifference %= HOUR;
		  typeTime = "Hours";
		}
		if (milliDifference%MINUTE > 0) {
		  //progString.append(milliDifference / MINUTE).append(" minutes ");
		  milliDifference %= MINUTE;
		  typeTime = "Minutes";
		}
		else {
		  //progString.append(milliDifference / SECOND).append(" seconds ");
		  milliDifference %= SECOND;
		  typeTime = "Seconds";
		}
		
		//Add the difference to the accumulated total
		//acuumTime += milliDifference;
		
		TimeLength myTime = new TimeLength(typeTime, milliDifference);
		return myTime;
	}
	
	/*
	 * Aaron Lajom
	 * The purpose of this method is to append both time and progress to the their respected vectors
	 */
	public void appendProgAndTime() {
		
		//Calculate the current difference in time
		TimeLength thisTime = calcTime ();
		
		int progSize = progress.size();
		int progMaxRef = progSize - 1;
		int timesSize = times.size();
		//int timesMaxRef = timesSize - 1;
		
		//If the size of the times vector is not zero and barely any time has passed, it will add the progress 
		//to the last bit of progress
		if (timesSize != 0 && (thisTime.getType().equals("Minutes") || thisTime.getType().equals("Seconds"))) {
			progress.set(progMaxRef, progress.get(progMaxRef) + task.getProgress());
		}
		//Otherwise just add it
		else { 
			times.add(thisTime);
			progress.add(task.getProgress());
		}
		
	}
	
	public String generateString () {
		if (times.size() == 0) {
			progString = "No progress has been made!";
		}
		else {
			progString = "Progress: ";
			
			for(int i = 0; i < progress.size(); i++) {
				progString += (times.get(i).getLength() + " " + times.get(i).getType() + ", ");
			}
		}
		return progString;
	}

}
