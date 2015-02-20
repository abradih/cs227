package hw1;

/**
 * Makes alarm clock.
 * 
 * @author Amber
 *
 */
public class AlarmClock {

	public static final int SNOOZE_MINUTES = 9;
	public static final int MINUTES_PER_DAY = 1440;

	private int time;
	private int alarmTime;
	private int effectiveAlarmTime;
	private boolean alarmOn;
	private boolean ringing;

	/**
	 * Makes an alarm clock with given time.
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
	 * Makes alarm clock with set time at midnight.
	 */
	public AlarmClock() {
		time = 0;
		alarmTime = 60;
		effectiveAlarmTime = alarmTime;
		alarmOn = false;
		ringing = false;
	}

	public void advanceTime(int minutes) {
		int preTime = time;
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
		ringing = (preTime < effectiveAlarmTime) && (time <= effectiveAlarmTime);	
	}

	public void advanceTime(int hours, int minutes) {
		advanceTime((hours * 60) + minutes); 
	}

	public void alarmOff() {
		alarmOn = false;
	}

	public void alarmOn() {
		alarmOn = true;
	}

	public int getAlarmTime() {
		return alarmTime;
	}

	public String getAlarmTimeAsString() {
		int hours = (alarmTime / 60);
		int minutes = (alarmTime % 60);
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}

	public int getClockTime() {
		return time;
	}

	public String getClockTimeAsString() {
		return stringTime(time);
	}

	public int getEffectiveAlarmTime() {
		return effectiveAlarmTime;
	}

	public String getEffectiveAlarmTimeAsString() {
		return stringTime(effectiveAlarmTime);
	}

	public boolean isRinging() {
		return ringing && alarmOn;
	}

	public void setAlarmTime(int hours, int minutes) {
		alarmTime = hours * 60;
		alarmTime = alarmTime + minutes;
		alarmTime = alarmTime % MINUTES_PER_DAY;
		effectiveAlarmTime = alarmTime;
	}

	public void setTime(int hours, int minutes) {
		time = hours * 60;
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
	}

	public void snooze() {
		if (ringing){
			effectiveAlarmTime = time + SNOOZE_MINUTES;
			effectiveAlarmTime = effectiveAlarmTime % MINUTES_PER_DAY;
		}
	}

	private String stringTime(int clockTime) {
		int hours = (clockTime / 60);
		int minutes = (clockTime % 60);
		String timeString = String.format("%02d:%02d", hours, minutes);
		return timeString;
	}
}
