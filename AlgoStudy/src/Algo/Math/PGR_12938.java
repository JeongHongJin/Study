package Algo.Math;

import java.util.Arrays;

public class PGR_12938 {
	class Solution {
		public int[] solution(int n, int s) {
			int[] answer = {};
			int tmp = s / n;
			if (tmp == 0) {
				answer = new int[1];
				answer[0] = -1;
				return answer;
			}
			answer = new int[n];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = tmp;
			}
			tmp *= n;
			int idx = 0;
			tmp = s % n;
			for (int i = 0; i < tmp; i++) {
				answer[idx]++;
				idx++;
			}
			Arrays.sort(answer);
			return answer;
		}
	}
}
