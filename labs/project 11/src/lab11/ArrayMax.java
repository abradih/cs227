package lab11;

public class ArrayMax {

	public static void main(String[] args) {
		int[] test = { 3, 4, 5, 1, 2, 3, 2 }; // sum should be 20
		int result = arrayMax(test);
		System.out.println(result);
	}

	/**
	 * Returns the sum of all array elements.
	 */
	public static int arrayMax(int[] arr) {
		return arrayMax(arr, 0, arr.length - 1);
	}

	/**
	 * Returns the sum of array elements from start to end, inclusive.
	 */
	private static int arrayMax(int[] arr, int start, int end) {
		if (start == end) {
			return arr[start];
		} else {
			int mid = (start + end) / 2;
			int leftMax = arrayMax(arr, start, mid);
			int rightMax = arrayMax(arr, mid + 1, end);
			if (leftMax > rightMax) {
				return leftMax;
			} else {
				return rightMax;
			}
		}
	}
}
