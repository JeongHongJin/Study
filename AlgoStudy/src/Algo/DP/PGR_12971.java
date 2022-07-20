package Algo.DP;

public class PGR_12971 {
	class Solution {
		public int solution(int sticker[]) {
			int answer = 0;
			int n = sticker.length;
			int[] dp = new int[n + 1];
			int[] dp2 = new int[n + 1];
			if (n == 1)
				return sticker[0];
			// 첫번째 스티커 떼는경우
			dp[0] = sticker[0];
			dp[1] = sticker[0];
			for (int i = 2; i < n; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
			}
			// 안떼는 경우
			dp2[0] = 0;
			dp2[1] = sticker[1];
			for (int i = 2; i < n; i++) {
				dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
			}
			answer = Math.max(dp[n - 2], dp2[n - 1]);
			return answer;
		}
	}
}
