package Algo.BackTracking;

import java.util.ArrayList;

public class PGR_92342 {
	class Solution {
		int goal;
		int max = 0;
		int min = 0;
		ArrayList<int[]> list;
		int[] out;
		int[] answer;

		public int[] solution(int n, int[] info) {
			int[] answer = { -1 };
			out = new int[info.length];
			goal = n;
			list = new ArrayList<int[]>();
			dfs(0, 0, info, out);
			if (list.size() == 0)
				return answer;
			for (int[] tmp : list) {
				int sum = 0;
				for (int i = 0; i < tmp.length; i++) {
					if (info[i] == 0 && tmp[i] == 0)
						continue;
					if (info[i] < tmp[i]) {
						sum += (10 - i);
					} else {
						sum -= (10 - i);
					}
				}
				if (sum == max) {
					if (answer.length == 1) {
						answer = tmp.clone();
						continue;
					}
					for (int i = tmp.length - 1; i >= 0; i--) {
						if (tmp[i] > answer[i]) {
							answer = tmp.clone();
							break;
						} else if (tmp[i] == 0 && answer[i] == 0) {

						} else {
							break;
						}
					}
				}

			}
			return answer;
		}

		void dfs(int start, int depth, int[] info, int[] out) {
			if (depth == goal) {
				if (check(info, out)) {
					list.add(out.clone());
				}
				return;
			}
			for (int i = start; i < info.length; i++) {
				if (info[i] >= out[i]) {
					out[i]++;
					dfs(i, depth + 1, info, out);
					out[i]--;
				}
			}
		}

		boolean check(int[] info, int[] out) {
			int score = 0;

			for (int i = 0; i < info.length; i++) {
				if (info[i] == 0 && out[i] == 0)
					continue;
				if (info[i] < out[i]) {
					score += (10 - i);
				} else {
					score -= (10 - i);
				}
			}

			if (score > 0 && max <= score) {
				max = Math.max(max, score);
				return true;
			} else {
				return false;
			}
		}
	}
}
