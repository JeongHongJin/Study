package Algo.DP;

public class PGR_131129 {
	class Solution {
		public int[] solution(int target) {
			int[] answer = new int[2];
			int[] dp = new int[100001];
			int[] dp2 = new int[100001];
			int[] arr = new int[42];
			arr[20] = 50;
			for (int i = 0; i < 20; i++) {
				arr[i] = i + 1;
			}
			int idx = 21;
			for (int i = 21; i <= 40; i++) {
				if (i % 2 == 0) {
					arr[idx++] = i;
				}
			}
			for (int i = 21; i <= 60; i++) {
				if (i % 3 == 0 && i % 2 != 0) {
					arr[idx++] = i;
				} else if (i % 3 == 0 && i > 40) {
					arr[idx++] = i;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				dp[arr[i]] = 1;
				if (i < 21) {
					dp2[arr[i]] = 1;
				}
			}
			for (int i = 23; i <= target; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i >= arr[j]) {
						if (j < 21) {
							if (dp[i - 1] + 1 >= dp[i - arr[j]] + 1) {
								dp[i] = dp[i - arr[j]] + 1;
								dp2[i] = dp2[i - arr[j]] + 1;
							} else {
								dp[i] = dp[i - 1] + 1;
								dp2[i] = dp2[i - 1] + 1;
							}
						} else {
							if (dp[i - 1] + 1 >= dp[i - arr[j]] + 1) {
								if (dp[i - arr[j]] + 1 >= dp[i]) {
									dp[i] = dp[i];
									dp2[i] = dp2[i];
								} else {
									dp[i] = dp[i - arr[j]] + 1;
									dp2[i] = dp2[i - arr[j]];
								}
							} else {
								if (dp[i - 1] + 1 >= dp[i]) {
									dp[i] = dp[i];
									dp2[i] = dp2[i];
								} else {
									dp[i] = dp[i - 1] + 1;
									dp2[i] = dp2[i - 1] + 1;
								}
							}
						}
					}

				}
			}
			answer[0] = dp[target];
			answer[1] = dp2[target];
			return answer;
		}
	}
}
