package lab4;

import java.util.Scanner;

import lab2.Atom;

public class DelimiterUse {
	public static void main(String[] args) {
		Scanner parser = new Scanner("Uranium;U;92;92;146");
		parser.useDelimiter(";");

		// Skip over first two fields. Notice how we can just ignore the value
		// returned by the next() method?
		String name = parser.next();
		parser.next(); // skip over the "U", we don't need to save it
		int protons = parser.nextInt();
		int electrons = parser.nextInt();
		int neutrons = parser.nextInt();
		System.out.println(name);
		Atom atom = new Atom(protons, neutrons, electrons);
		System.out.println("Atomic mass: " + atom.getAtomicMass());
		parser.close();
	}
}