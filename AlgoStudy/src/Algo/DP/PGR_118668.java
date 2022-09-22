package Algo.DP;

public class PGR_118668 {
	class Solution {
		public int solution(int alp, int cop, int[][] problems) {
			int answer = 0;
			int aMax = 0;
			int cMax = 0;

			for (int i = 0; i < problems.length; i++) {
				aMax = Math.max(problems[i][0], aMax);
				cMax = Math.max(problems[i][1], cMax);
			}
			// 알고력 코딩력이 이미 목표점인 경우
			if (aMax <= alp && cMax <= cop) {
				return 0;
			}
			if (alp >= aMax) {
				alp = aMax;
			}
			if (cop >= cMax) {
				cop = cMax;
			}

			int[][] dp = new int[151][151];

			for (int i = alp; i <= aMax; i++) {
				for (int j = cop; j <= cMax; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}

			dp[alp][cop] = 0;

			for (int i = alp; i <= aMax; i++) {
				for (int j = cop; j <= cMax; j++) {
					// 알고력 코딩력 1씩 학습한경우
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
					dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

					// 모든 케이스 확인
					for (int[] p : problems) {
						int alp_req = p[0];
						int cop_req = p[1];
						int alp_rwd = p[2];
						int cop_rwd = p[3];
						int cost = p[4];

						// 둘다 알고력, 코딩력 조건에 부합한 경우
						if (i >= alp_req && j >= cop_req) {
							if (i + alp_rwd > aMax && j + cop_rwd > cMax) {
								// 알고력 목표 초과, 코딩력 목표 초과
								dp[aMax][cMax] = Math.min(dp[aMax][cMax], dp[i][j] + cost);
							} else if (i + alp_rwd > aMax) {
								// 알고력 목표 초과
								dp[aMax][j + cop_rwd] = Math.min(dp[aMax][j + cop_rwd], dp[i][j] + cost);
							} else if (j + cop_rwd > cMax) {
								// 코딩력 목표 초과
								dp[i + alp_rwd][cMax] = Math.min(dp[i + alp_rwd][cMax], dp[i][j] + cost);
							} else if (i + alp_rwd <= aMax && j + cop_rwd <= cMax) {
								// 둘 다 목표 이하
								dp[i + alp_rwd][j + cop_rwd] = Math.min(dp[i + alp_rwd][j + cop_rwd], dp[i][j] + cost);
							}
						}

					}
				}
			}

			return dp[aMax][cMax];
		}
	}
}
