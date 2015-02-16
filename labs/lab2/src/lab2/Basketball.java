package lab2;

/**
 * Model of a basketball for use in quality control simulations.
 * @author Amber
 *
 */
public class Basketball {

	/**
	 * Inflation status of this Basketball.
	 */
	private boolean isInflated;
	
	/**
	 * Diameter of this Basketball.
	 */
	private double diameter;

	/**
	 * Constructs an uninflated Basketball with the given diameter.
	 * Made by Amber!
	 * @param theDiameter
	 * the diameter for this Basketball
	 */
	public Basketball(double theDiameter) {
		isInflated = false;
		diameter = theDiameter;
	}

	/**
	 * Returns the diameter of this Basketball.
	 * @return
	 * diameter of this Basketball
	 */
	public double getDiameter() {
		return diameter;
	}

	/**
	 * Determines whether this Basketball can be dribbled.
	 * @return
	 * true if the basketball is inflated, false otherwise
	 */
	public boolean isDribbleable() {
		// can be dribbled only if it is inflated
	    return isInflated;
	}
 
	/**
	 * Inflates this Basketball.
	 */
	public void inflate() {
		isInflated = true;
	}

	/**
	 * Returns the circumference of this Basketball.
	 * @return
	 * circumference of this Basketball
	 */
	public double getCircumference() {
		double result = Math.PI * diameter;
		return result;
	}
}
