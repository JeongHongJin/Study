package AlgoPuzzle68;

public class Q9_unBalance {
	public static void main(String[] args) {
		int boy = 20;
		int girl = 10;
		int[][] arr = new int[11][21];
		arr[0][0] = 1;
		for (int i = 0; i <= girl; i++) {
			for (int j = 0; j <= boy; j++) {
				if ((i != j) && (boy - j != girl - i)) {
					if (j > 0) {
						arr[i][j] += arr[i][j - 1];
					}
					if (i > 0) {
						arr[i][j] += arr[i - 1][j];
					}
				}
			}
		}
		System.out.println(arr[girl - 1][boy] + arr[girl][boy - 1]);
	}
}
