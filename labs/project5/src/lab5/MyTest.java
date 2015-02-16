package lab5;

import balloon.Balloon;

public class MyTest {

	public static void main(String[] args) {
		Balloon b = new Balloon(5);
		b.blow(4);
		b.deflate();
		System.out.println(b.getRadius());
		System.out.println(b.isPopped());
	}

}
