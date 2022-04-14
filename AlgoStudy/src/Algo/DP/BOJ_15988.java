package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			long[] dp = new long[m];
			if (m == 1) {
				sb.append(1).append('\n');
				continue;
			} else if (m == 2) {
				sb.append(2).append('\n');
				continue;
			} else if (m == 3) {
				sb.append(4).append('\n');
				continue;
			}
			dp[0] = 1;
			dp[1] = 2;
			dp[2] = 4;
			for (int j = 3; j < m; j++) {
				dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
			}
			sb.append(dp[m - 1]).append('\n');
		}
		System.out.println(sb);
	}
}
