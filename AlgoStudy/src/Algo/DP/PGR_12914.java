package Algo.DP;

public class PGR_12914 {
	class Solution {
		public long solution(int n) {
			long answer = 0;
			int mod = 1234567;
			long[] dp = new long[n + 1];
			if (n == 1) {
				return 1;
			}
			dp[1] = 1l;
			dp[2] = 2l;

			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
			}
			return dp[n];
		}
	}
}
