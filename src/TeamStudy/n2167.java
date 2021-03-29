package TeamStudy;

import java.util.Scanner;

public class n2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] num = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for (int a = 0; a < K; a++) {
			answer = 0;
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int b = j - 1; b < y; b++) {
				for (int c = i - 1; c < x; c++) {
					answer += num[c][b];
				}
			}
			System.out.println(answer);
		}

		sc.close();
	}
}
