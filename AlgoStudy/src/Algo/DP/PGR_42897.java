package Algo.DP;

public class PGR_42897 {
	class Solution {
		public int solution(int[] money) {
			int answer = 0;
			int n = money.length;
			int[] dp = new int[n];
			int[] dp2 = new int[n];
			if (n == 1)
				return money[0];
			dp[0] = money[0];
			dp[1] = money[0];
			for (int i = 2; i < n; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
			}
			dp2[0] = 0;
			dp2[1] = money[1];
			for (int i = 2; i < n; i++) {
				dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
			}
			answer = Math.max(dp[n - 2], dp2[n - 1]);
			return answer;
		}
	}
}
