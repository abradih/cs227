package lab5;

public class Basketball{
	
	private boolean inflated;
	private double diameter;
	
	public Basketball(double givenDiameter) {
		diameter = givenDiameter;
	}

	public boolean isDribbleable() {
		return inflated;
	}

	public double getDiameter() {
		return diameter;
	}

	public double getCircumference() {
		return diameter * Math.PI;
	}

	public void inflate() {
		inflated = true;
	}
}
