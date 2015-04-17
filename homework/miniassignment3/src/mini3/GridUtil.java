package mini3;

/**
 * Utility class for applying transformations to 2d arrays. A transformation
 * computes a new value for a cell that is based on the square neighborhood of
 * cells that surround it. Each transformation is an implementation of the
 * ITransform interface.
 */
public class GridUtil {
	/**
	 * Applies the given transformation to all cells of the given array and
	 * produces a new array of the same size. The original array is not
	 * modified.
	 * 
	 * @param arr
	 *            given array
	 * @param transform
	 *            transformation to apply
	 * @return new array consisting of transformed values
	 */
	public static int[][] applyAll(int[][] arr, ITransform transform) {
		int numRows = arr.length;
		int numCols = arr[0].length;
		int[][] result = new int[numRows][numCols];
		for (int row = 0; row < numRows; row += 1) {
			for (int col = 0; col < numCols; col += 1) {
				int[][] subArray = getSubArray(arr, row, col, transform.getRadius(), transform.isWrapped());
				int newValue = transform.apply(subArray);
				result[row][col] = newValue;
			}
		}
		return result;
	}

	/**
	 * Returns the neighborhood surrounding the specified cell. In general, the
	 * returned array is a square sub-array of <code>arr</code>, with width and
	 * height 2 * <code>radius</code> - 1, whose center is
	 * <code>arr[centerRow][centerCol]</code>. For cells within
	 * <code>radius</code> of the edge, the value for out-of-range indices is
	 * determined by the <code>wrapped</code> parameter, as follows:
	 * <ul>
	 * <li>if <code>wrapped</code> is false, cells for out-of-range indices are
	 * filled with zeros
	 * <li>if <code>wrapped</code> is true, cells for out-of-range indices are
	 * determined by "wrapping" the indices:
	 * <ul>
	 * <li>for a row index, the array height is added to or subtracted from the
	 * index to bring it within range
	 * <li>for a column index, the array width is added to or subtracted from
	 * the index to bring it within range
	 * </ul>
	 * </ul>
	 * Note that the size of neighborhood, neighborhood size 2 *
	 * <code>radius</code> + 1, is not allowed to be greater than either the
	 * width or height of the given array.
	 * 
	 * @param arr
	 *            the original array
	 * @param centerRow
	 *            row index of center cell
	 * @param centerCol
	 *            column index of center cell
	 * @param radius
	 *            radius of the neighborhood (return array has width and height
	 *            equal to 2 * <code>radius</code> + 1
	 * @param wrapped
	 *            true if out-of-range indices should be wrapped, false if cells
	 *            should be filled with zeros
	 * @return a new 2d array consisting of the cells surrounding the given
	 *         center cell
	 * @throws IllegalArgumentException
	 *             if the neighborhood size 2 * <code>radius</code> + 1 is
	 *             greater than the given array's width or height
	 */
	public static int[][] getSubArray(int[][] arr, int centerRow, int centerCol, int radius, boolean wrapped) {
		int[][] result = new int[(radius * 2) + 1][(radius * 2) + 1];
		if (wrapped == true) {
			
		} else {
			int spot1 = 0;
			int spot2 = 0;
			for (int i = centerRow - radius; i <= centerRow + radius; i++) {
				for (int i2 = centerCol - radius; i2 <= centerCol + radius; i2++) {
					if (i >= 0 && i2 >= 0 && i < arr.length && i2 < arr[i].length) {
						result[spot1][spot2] = arr[i][i2];
					}
					spot2++;
				}
				spot2 = 0;
				spot1++;
			}
		}
		return result;
	}
}
