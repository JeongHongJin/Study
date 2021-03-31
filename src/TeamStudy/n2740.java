package TeamStudy;

import java.util.Scanner;

public class n2740 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		int X = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr2 = new int[X][K];
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < K; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				answer = 0;
				for (int k = 0; k < M; k++) {
					answer += arr1[i][k] * arr2[k][j];
				}
				System.out.print(answer);
				if (j != K - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
