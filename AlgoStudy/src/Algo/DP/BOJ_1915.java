package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		long max = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = map[i][j];
				if (i >= 1 && j >= 1) {
					if (dp[i - 1][j] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j - 1] > 0 && dp[i][j] > 0) {
						int min = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
						dp[i][j] = min + 1;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max * max);
	}
}
