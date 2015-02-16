package lab2;

/**
 * Defines an atom
 * 
 * @author Amber
 *
 */
public class Atom {

	private int protons;
	private int neutrons;
	private int electrons;

	/**
	 * constructs new atom given protons, neutrons and electron
	 * 
	 * @param givenProtons
	 * @param givenNeutrons
	 * @param givenElectrons
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
	}

	/**
	 * returns total number of protons plus neutrons
	 * 
	 * @return
	 */
	public int getAtomicMass() {
		return protons + neutrons;
	}

	/**
	 * returns the difference between the number of protons and electrons
	 * 
	 * @return
	 */
	public int getAtomicCharge() {
		return protons - electrons;
	}

	/**
	 * decreases the number of protons by 2 and the number of neutrons by 2
	 */
	public void decay() {
		protons = protons - 2;
		neutrons = neutrons - 2;
	}

}
