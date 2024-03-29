package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mod = 9901;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 3;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % mod;
		}
		System.out.println(dp[n]);
	}
}
