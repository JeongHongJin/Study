package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
	static char[][] board;
	static int n;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		// 가로인 경우
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(i, j, i, j + 1);
				check();
				swap(i, j, i, j + 1);
			}
		}
		// 세로인 경우
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				swap(j, i, j + 1, i);
				check();
				swap(j, i, j + 1, i);
			}
		}
		System.out.println(max);
	}

	// 사탕 교환
	static void swap(int x1, int y1, int x2, int y2) {
		char tmp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = tmp;
	}

	// 사탕 최대로 많이 먹는 경우, 행 열만 먹는다.
	static void check() {
		int cnt = 1;
		// 가로
		for (int i = 0; i < n; i++) {
			cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (board[i][j] == board[i][j + 1])
					cnt++;
				else
					cnt = 1;
				max = Math.max(max, cnt);
			}
		}
		// 세로
		for (int i = 0; i < n; i++) {
			cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (board[j][i] == board[j + 1][i])
					cnt++;
				else
					cnt = 1;
				max = Math.max(max, cnt);
			}
		}
	}
}
