package mini1;

/**
 * Defines a Taxi
 * 
 * @author Amber
 *
 */
public class Taxi {

	// life of taxi
	private double odometer;
	private double totalFares;
	// per ride
	private double meter;
	private double currentRate;
	private double baseFare;
	private double perMileRate;

	public Taxi(double givenBaseFare, double givenPerMileRate) {
		// life of taxi
		odometer = 0;
		totalFares = 0;
		// per ride
		perMileRate = givenPerMileRate;
		baseFare = givenBaseFare;
		// resets after ride
		meter = 0;
		currentRate = 0;
	}

	public double getTotalMiles() {
		return odometer;
	}

	public double getTotalCash() {
		return totalFares;
	}

	public double getCurrentRate() {
		return currentRate;
	}

	public double getMeter() {
		return meter;
	}

	public void drive(double milesDriven) {
		odometer = odometer + milesDriven;
		meter = meter + (currentRate * milesDriven);
	}

	public void startRide() {
		currentRate = perMileRate;
		meter = baseFare;
	}

	public void endRide() {
		totalFares = totalFares + meter;
		currentRate = 0;
		meter = 0;
	}

	public double getAverageIncomePerMile() {
		return totalFares / odometer;
	}
}