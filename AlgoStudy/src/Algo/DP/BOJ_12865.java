package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			str = br.readLine().split(" ");
			w[i] = Integer.parseInt(str[0]);
			v[i] = Integer.parseInt(str[1]);
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
