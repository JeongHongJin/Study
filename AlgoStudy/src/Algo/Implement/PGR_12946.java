package Algo.Implement;

import java.util.ArrayList;

public class PGR_12946 {
	class Solution {
		ArrayList<int[]> list = new ArrayList<>();

		public int[][] solution(int n) {
			int[][] answer = {};
			hanoi(n, 1, 3, 2);
			answer = new int[list.size()][2];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}

		public void hanoi(int n, int from, int to, int tmp) {
			if (n == 1) {
				list.add(new int[] { from, to });
				return;
			}
			hanoi(n - 1, from, tmp, to);
			list.add(new int[] { from, to });
			hanoi(n - 1, tmp, to, from);
		}
	}
}
