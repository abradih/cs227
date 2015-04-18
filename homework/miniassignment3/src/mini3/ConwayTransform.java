package mini3;

/**
 * Transformation implementing Conway's Game of Life. All cells have value 0 or
 * 1. The new value is based on the center cell along with the sum S of its
 * eight neighbors, according to the rules:
 * <ul>
 * <li>if S < 2 the result is 0
 * <li>if the center cell is 1 and S is 2 or 3, the result is 1
 * <li>if S > 3 the result is 0
 * <li>if the center cell is 0 and S is exactly 3, the result is 1
 * </ul>
 * See http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 * <p>
 * The radius is 1 and the wrapping behavior is true.
 */
public class ConwayTransform implements ITransform {

	@Override
	public int apply(int[][] elements) {
		int size = (2 * getRadius()) + 1;
		for (int i = 0; i < elements.length; i++) {
			if (size != elements.length || size != elements[i].length) {
				throw new IllegalArgumentException("2*radius+1 is not equal to the given array's width or height");
			}
		}
		int cell = elements[getRadius()][getRadius()];
		int result = cell;
		int numNeighbors = countNeighbors(elements, cell);
		// rule 1
		if (numNeighbors < 2){
			result = 0;
		}
		//rule 2
		if(cell == 1 && (numNeighbors == 2 || numNeighbors == 3 )){
			result = 1;
		}
		//rule 3
		if(numNeighbors > 3){
			result = 0;
		}
		//rule 4
		if(cell == 0 && numNeighbors == 3){
			result = 1;
		}
		return result;
	}

	@Override
	public int getRadius() {
		return 1;
	}

	@Override
	public boolean isWrapped() {
		return true;
	}

	private int countNeighbors(int[][] neighbors, int cell) {
		int result = 0;
		for (int i = 0; i < neighbors.length; i++) {
			for (int i2 = 0; i2 < neighbors[i].length; i2++) {
				if (neighbors[i][i2] == 1) {
					result = result + 1;
				}
			}
		}
		result = result - cell;
		return result;
	}

}
