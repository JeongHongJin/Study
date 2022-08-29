package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int answer = Integer.MAX_VALUE;

		int[] memory = new int[n];
		int[] cost = new int[n];
		int[][] dp = new int[n][100001];
		str = br.readLine().split(" ");
		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(str[i]);
			cost[i] = Integer.parseInt(str2[i]);
		}
		for (int i = 0; i < n; i++) {
			int c = cost[i];
			int mem = memory[i];
			for (int j = 0; j <= 100000; j++) {
				if (i == 0) {
					if (j >= c) {
						dp[i][j] = mem;
					}
				} else {
					if (j >= c) {
						dp[i][j] = Math.max(dp[i - 1][j - c] + mem, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
				if (dp[i][j] >= m) {
					answer = Math.min(answer, j);
				}
			}
		}
		System.out.println(answer);
	}
}
