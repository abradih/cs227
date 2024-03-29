package lab4;

import java.util.Scanner;
import lab2.Atom;

public class AtomReader
{
  public static void main(String[] args)
  {
     String text = "Uranium U 92 92 146";
     Scanner parser = new Scanner(text);
     String name = parser.next();
     parser.next();  // skip over the "U", we don't need to save it
     int protons = parser.nextInt();
     int electrons = parser.nextInt();
     int neutrons = parser.nextInt();
     System.out.println(name);
     Atom atom = new Atom(protons, neutrons, electrons);
     System.out.println("Atomic mass: " + atom.getAtomicMass());
     parser.close();
  }
}