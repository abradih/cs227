package hw1;

/**
 * Makes alarm clock.
 * 
 * @author Amber
 *
 */
public class AlarmClock {
	private int hours;
	private int minutes;

	/**
	 * Makes alarm clock with given parameters.
	 * 
	 * @param givenHours
	 * @param givenMinutes
	 */
	public AlarmClock(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;

	}

	/**
	 * Makes alarm clock time set at midnight and alarm set at 1:00.
	 */
	public AlarmClock() {
		hours = 0;
		minutes = 0;
	}

	public void advanceTime(int minutes) {
		this.minutes = minutes;
	}

	public void advanceTime(int hours, int minutes) {
		this.hours = this.hours + hours;
		this.minutes = this.minutes + minutes;
	}

	public void alarmOff() {

	}

	public void alarmOn() {

	}

	public int getAlarmTime() {
		return 0;
	}

	public String getAlarmTimeAsString() {
		return "00:00";
	}

	public int getClockTime() {
		return 0;
	}

	public String getClockTimeAsString() {
		return "00:00";
	}

	public int getEffectiveAlarmTime() {
		return 0;
	}

	public String getEffectiveAlarmTimeAsString() {
		return "00:00";
	}

	public boolean isRinging() {
		return true;
	}

	public void setAlarmTime(int hours, int minutes) {
	}

	public void setTime(int hours, int minutes) {
	}

	public void snooze() {
	}
}
