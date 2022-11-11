package Algo.Math;

import java.util.Arrays;

public class PGR_135808 {
	class Solution {
		public int solution(int k, int m, int[] score) {
			int answer = 0;
			Arrays.sort(score);
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			for (int i = score.length - 1; i >= 0; i--) {
				int now = score[i];
				if (now <= k)
					cnt++;
				min = Math.min(score[i], min);
				if (cnt == m) {
					cnt = 0;
					answer += min * m;
				}
			}
			return answer;
		}
	}
}
