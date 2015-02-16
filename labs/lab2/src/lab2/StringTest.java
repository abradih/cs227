package lab2;

public class StringTest {
	public static void main(String[] args) {

		String message = "Hello, world!";
		System.out.println(message);

		int theLength = message.length();
		System.out.println(theLength);

		char theChar = message.charAt(6);
		System.out.println(theChar);

		theChar = message.charAt(4);
		System.out.println(theChar);

		String bigMessage = message.toUpperCase();
		System.out.println(bigMessage);

		String shortMessage = message.substring(0, 5);
		System.out.println(shortMessage);

		String replaceMessage = message.replace('o', '*');
		System.out.println(replaceMessage);
	}
}
