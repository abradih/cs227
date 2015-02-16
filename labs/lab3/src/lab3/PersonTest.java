package lab3;

public class PersonTest {
	public static void main(String[] args){
		Person bob = new Person("Bob", 25);
		System.out.println(bob.getAge());
		System.out.println(bob.getName());
		System.out.println(bob.getNameLength());
	}

}
