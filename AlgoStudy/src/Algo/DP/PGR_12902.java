package Algo.DP;

public class PGR_12902 {
	class Solution {
		public int solution(int n) {
			int answer = 0;
			int mod = 1000000007;
			if (n % 2 != 0)
				return 0;
			long[] dp = new long[n + 1];
			dp[2] = 3;
			for (int i = 4; i <= n; i += 2) {
				dp[i] = (dp[i - 2] * 3) + 2;
				for (int j = 1; j <= (i - 4) / 2; j++) {
					dp[i] += (dp[2 * j] * 2);
				}
				dp[i] %= mod;
			}
			return (int) dp[n];
		}
	}
}
