package TeamStudy;

import java.util.Scanner;

public class n5533 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < N; y++) {
				int cnt = 0;
				for (int z = 0; z < N; z++) {
					if (arr[y][x] == arr[z][x]) {
						cnt++;
						if (cnt == 2) {
							break;
						}
					}
				}
				if (cnt == 1) {
					answer[y] += arr[y][x];
				}
			}

		}
		for (int m = 0; m < answer.length; m++) {
			System.out.println(answer[m]);
		}
		sc.close();
	}
}
