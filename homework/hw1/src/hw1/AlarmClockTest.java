package hw1;

public class AlarmClockTest {

	public static void main(String[] args) {
		AlarmClock clock = new AlarmClock();
		clock.setTime(5, 0);
		clock.setAlarmTime(5, 15);
		System.out.println(clock.getAlarmTimeAsString());
		System.out.println(clock.getEffectiveAlarmTimeAsString());
		clock.alarmOn();
		clock.advanceTime(30);
		System.out.println(clock.isRinging());
		clock.advanceTime(5);
		clock.snooze();
		System.out.println(clock.isRinging());
		System.out.println(clock.getAlarmTimeAsString());
		System.out.println(clock.getEffectiveAlarmTimeAsString());
	}
}
