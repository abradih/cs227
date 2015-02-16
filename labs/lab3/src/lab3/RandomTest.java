package lab3;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random randm = new Random(137);
		
		System.out.println(randm.nextInt(6));
		System.out.println(randm.nextInt(6));
		System.out.println(randm.nextInt(6));
		System.out.println(randm.nextInt(6));
		System.out.println(randm.nextInt(6));
		System.out.println(randm.nextInt(6));
		
	}

}
