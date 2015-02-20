package hw1;

public class AlarmClockTest {

	public static void main(String[] args) {
		AlarmClock clock = new AlarmClock();
		clock.setTime(5, 30);
		clock.setAlarmTime(5, 30);
		clock.alarmOn();
		clock.advanceTime(1440);
		System.out.println("Ringing: " + clock.isRinging());
		System.out.println(clock.getAlarmTimeAsString());
		System.out.println(clock.getEffectiveAlarmTimeAsString());
	}
}
