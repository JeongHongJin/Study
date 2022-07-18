package Algo.DP;

public class PGR_42898 {
	class Solution {
		public int solution(int m, int n, int[][] puddles) {
			int answer = 0;
			int mod = 1000000007;
			int[][] dp = new int[m + 1][n + 1];
			dp[0][0] = 1;
			for (int i = 0; i < puddles.length; i++) {
				int r = puddles[i][0];
				int c = puddles[i][1];
				dp[r][c] = -1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (dp[i][j] == -1) {
						dp[i][j] = 0;
						continue;
					}
					if (i != 0) {
						dp[i][j] += dp[i - 1][j] % mod;
					}
					if (j != 0) {
						dp[i][j] += dp[i][j - 1] % mod;
					}
				}
			}
			return dp[m - 1][n - 1];
		}
	}
}
