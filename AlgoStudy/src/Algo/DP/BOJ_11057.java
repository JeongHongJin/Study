package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][10];
		int mod = 10007;
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] += dp[i - 1][k];
				}
				dp[i][j] %= mod;
			}
		}
		for (int i = 0; i < 10; i++) {
			answer += dp[n][i];
			answer %= mod;
		}
		System.out.println(answer);
	}
}
