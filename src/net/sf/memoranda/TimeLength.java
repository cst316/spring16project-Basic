package net.sf.memoranda;

/**
 * 
 */

/**
 * @author Aaron Lajom aka alajom
 *
 */
public class TimeLength {
	
	//Attributes
	private String timeType; //This can be day, hour, minutes, etc. ALWAYS PLURAL
	private long length; //This is the length of time (example: 3 for 3 days)
	
	TimeLength () {
		timeType = "Seconds";
		length = 0; 
	}
	
	TimeLength (String myType, long myLength) {
		timeType = myType;
		length = myLength;
	}
	
	public void setType (String myType) {
		timeType = myType;
	}
	
	public String getType () {
		return timeType;
	}
	
	public void setLength (long myLength) {
		length = myLength;
	}
	
	public long getLength () {
		return length;
	}
}