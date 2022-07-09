package Algo.DP;

import java.util.Arrays;

public class PGR_12907 {
	class Solution {
		public int solution(int n, int[] money) {
			int answer = 0;
			Arrays.sort(money);
			long[] dp = new long[n + 1];
			// 첫 거스름돈 초기화
			for (int i = 0; i <= n; i++) {
				if (i % money[0] == 0)
					dp[i] = 1;
			}
			// 냅색
			for (int i = 1; i < money.length; i++) {
				for (int j = money[i]; j <= n; j++) {
					dp[j] += dp[j - money[i]];
				}
				dp[i] %= 1000000007;
			}
			return (int) dp[n];
		}
	}
}
