package mini3;

/**
 * Transformation implementing a smoothing operation on cells of an array. The
 * new value is the average of the values in a neighborhood around a given cell,
 * rounded to the nearest integer. The size of the neighborhood is 2 * radius +
 * 1, where the radius is a parameter provided to the constructor. Values are
 * not wrapped.
 */
public class SmoothingTransform implements ITransform {
	private int radius;

	public SmoothingTransform(int givenRadius) {
		radius = givenRadius;
	}

	@Override
	public int apply(int[][] elements) {
		return avgNeighbors(elements, elements[getRadius()][getRadius()]);
	}

	@Override
	public int getRadius() {
		return radius;
	}

	@Override
	public boolean isWrapped() {
		return false;
	}

	public int avgNeighbors(int[][] neighbors, int cell) {
		int result = 0;
		for (int i = 0; i < neighbors.length; i++) {
			for (int i2 = 0; i2 < neighbors[i].length; i2++) {
				if (neighbors[i][i2] == 1) {
					result = result + 1;
				}
			}
		}
		result = result - cell;
		return result/((neighbors.length*2)-1);
	}
}
