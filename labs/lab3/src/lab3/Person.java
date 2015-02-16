package lab3;

public class Person {
	private String name;
	private int age;

	public Person(String getName, int getAge) {
		name = getName;
		age = getAge;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getNameLength() {
		return name.length();
	}
}