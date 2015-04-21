package lab11;

public class GetPyramidCount {

	public static void main(String[] args) {
		System.out.println(countBalls(7));
		System.out.println("expected: 140");
	}

	public static int countBalls(int levels) {
		if (levels == 1) {
			// base case
			return 1;
		} else {
			// general case
			int result = levels * levels;
			result = result + countBalls(levels - 1);
			return result;
		}
	}
}
