package hw1;

/**
 * Makes alarm clock.
 * 
 * @author Amber Aldrich
 */
public class AlarmClock {

	/**
	 * Number of minutes to silence the alarm when snoozing.
	 */
	public static final int SNOOZE_MINUTES = 9;

	/**
	 * Number of minutes in a 24-hour day.
	 */
	public static final int MINUTES_PER_DAY = 1440;

	/**
	 * Instance variable for clock time.
	 */
	private int time;
	
	/**
	 * Instance variable for alarm time.
	 */
	private int alarmTime;
	
	/**
	 * Instance variable for effective alarm time, the alarm time after snooze.
	 */
	private int effectiveAlarmTime;
	
	/**
	 * Instance variable for tracking if alarm is on (true) or off (false).
	 */
	private boolean alarmOn;
	
	/**
	 * Instance variable for tracking if alarm is ringing (true) or not ringing (false).
	 */
	private boolean ringing;

	/**
	 * Constructs an alarm clock with the given initial clock time and with
	 * alarm time at 01:00.
	 * 
	 * @param hours
	 * @param minutes
	 */
	public AlarmClock(int hours, int minutes) {
		time = hours * 60;
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
		alarmTime = 60;
		effectiveAlarmTime = alarmTime;
		alarmOn = false;
		ringing = false;
	}

	/**
	 * Constructs an alarm clock with initial clock time at 00:00 and alarm time
	 * at 01:00.
	 */
	public AlarmClock() {
		time = 0;
		alarmTime = 60;
		effectiveAlarmTime = alarmTime;
		alarmOn = false;
		ringing = false;
	}

	/**
	 * Advances the clock time by the specified number of minutes.
	 * 
	 * @param minutes
	 */
	public void advanceTime(int minutes) {
		// compute minutes till alarm will ring
		int minutesTillAlarm = effectiveAlarmTime - time;
		if (effectiveAlarmTime < time) {
			minutesTillAlarm = (MINUTES_PER_DAY - time) + effectiveAlarmTime;
		}
		// advance time
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
		// ringing is true if alarm is not set to current time, or it has been
		// one day (1440 minutes)
		// and advancing minutes past alarm time.
		ringing = (minutesTillAlarm != 0 || minutes >= MINUTES_PER_DAY)
				&& (minutes >= minutesTillAlarm);
	}

	/**
	 * Advances the clock time by the given hours and minutes.
	 * 
	 * @param hours
	 * @param minutes
	 */
	public void advanceTime(int hours, int minutes) {
		advanceTime((hours * 60) + minutes);
	}

	/**
	 * Turns off the alarm, stops it from ringing (if it is ringing) and cancels
	 * snooze if it is in effect.
	 */
	public void alarmOff() {
		alarmOn = false;
		effectiveAlarmTime = alarmTime;
	}

	/**
	 * Turns the alarm on.
	 */
	public void alarmOn() {
		alarmOn = true;
	}

	/**
	 * Returns the current alarm time as the number of minutes past midnight.
	 * 
	 * @return
	 */
	public int getAlarmTime() {
		return alarmTime;
	}

	/**
	 * Returns the current alarm time as a string of the form hh:mm.
	 * 
	 * @return
	 */
	public String getAlarmTimeAsString() {
		int hours = (alarmTime / 60);
		int minutes = (alarmTime % 60);
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}

	/**
	 * Returns the current clock time as the number of minutes past midnight.
	 * 
	 * @return
	 */
	public int getClockTime() {
		return time;
	}

	/**
	 * Returns the current clock time as a string of the form hh:mm.
	 * 
	 * @return
	 */
	public String getClockTimeAsString() {
		return stringTime(time);
	}

	/**
	 * Returns the effective alarm time as the number of minutes past midnight.
	 * 
	 * @return
	 */
	public int getEffectiveAlarmTime() {
		return effectiveAlarmTime;
	}

	/**
	 * Returns the effective alarm time as a string of the form hh:mm.
	 * 
	 * @return
	 */
	public String getEffectiveAlarmTimeAsString() {
		return stringTime(effectiveAlarmTime);
	}

	/**
	 * Determines whether the clock is currently ringing.
	 * 
	 * @return
	 */
	public boolean isRinging() {
		return ringing && alarmOn;
	}

	/**
	 * Sets the alarm time to the given hours and minutes.
	 * 
	 * @param hours
	 * @param minutes
	 */
	public void setAlarmTime(int hours, int minutes) {
		alarmTime = hours * 60;
		alarmTime = alarmTime + minutes;
		alarmTime = alarmTime % MINUTES_PER_DAY;
		effectiveAlarmTime = alarmTime;
	}

	/**
	 * Sets the current clock time to the given hours and minutes.
	 * 
	 * @param hours
	 * @param minutes
	 */
	public void setTime(int hours, int minutes) {
		time = hours * 60;
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
		effectiveAlarmTime = alarmTime;
	}

	/**
	 * Stops the clock from ringing and sets the effective alarm time for
	 * SNOOZE_MINUTES minutes after the current clock time.
	 */
	public void snooze() {
		if (ringing) {
			effectiveAlarmTime = time + SNOOZE_MINUTES;
			effectiveAlarmTime = effectiveAlarmTime % MINUTES_PER_DAY;
			ringing = false;
		}
	}
	
	/**
	 * Helper method to put time in string format. 
	 * @param clockTime
	 * @return
	 */
	private String stringTime(int clockTime) {
		int hours = (clockTime / 60);
		int minutes = (clockTime % 60);
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}
}
