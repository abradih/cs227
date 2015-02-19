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
	private boolean alarmOn;

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
		this.alarmTime = 60;
		alarmOn = false;
	}

	/**
	 * Makes alarm clock with set time at midnight.
	 */
	public AlarmClock() {
		time = 0;
		alarmTime = 60;
		alarmOn = false;
	}

	public void advanceTime(int minutes) {
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
	}

	public void advanceTime(int hours, int minutes) {
		time = time + (hours * 60);
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
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
		return (alarmTime / 60) + ":" + (alarmTime % 60);
	}

	public int getClockTime() {
		return time;
	}

	public String getClockTimeAsString() {
		return (time / 60) + ":" + (time % 60);
	}

	public int getEffectiveAlarmTime() {
		return getAlarmTime();
	}

	public String getEffectiveAlarmTimeAsString() {
		return getAlarmTimeAsString();
	}

	public boolean isRinging() {
		return (time == alarmTime) && alarmOn;
	}

	public void setAlarmTime(int hours, int minutes) {
		alarmTime = hours * 60;
		alarmTime = alarmTime + minutes;
		alarmTime = alarmTime % MINUTES_PER_DAY;
	}

	public void setTime(int hours, int minutes) {
		time = hours * 60;
		time = time + minutes;
		time = time % MINUTES_PER_DAY;
	}

	public void snooze() {
		alarmTime = alarmTime + SNOOZE_MINUTES;
		alarmTime = alarmTime % MINUTES_PER_DAY;
	}
}
