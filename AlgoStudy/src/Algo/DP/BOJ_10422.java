package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int mod = 1000000007;
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 2; i <= 2500; i++) {
			for (int j = 0; j < i; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - j - 1) * 2];
				dp[i * 2] %= mod;
			}
		}
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);
	}
}
