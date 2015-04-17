package mini3;


public class Test {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		arr[0][0] = 1;
		arr[2][2] = 1;
		arr[1][1] = 1;
		arr[3][3] = 1;
		arr[4][4] = 1;
		arr[0][4] = 1;
		arr[1][3] = 1;
		arr[3][1] = 1;
		arr[4][0] = 1;

		GridUtil.getSubArray(arr, 4, 4, 1, false);
		

	}

}
