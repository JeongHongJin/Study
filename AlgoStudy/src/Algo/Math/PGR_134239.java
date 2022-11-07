package Algo.Math;

import java.util.ArrayList;

public class PGR_134239 {
	class Solution {
		public double[] solution(int k, int[][] ranges) {
			double[] answer = new double[ranges.length];
			ArrayList<Integer> num = new ArrayList<>();
			ArrayList<Double> area = new ArrayList<>();
			int idx = 0;
			while (k > 1) {
				num.add(k);
				if (k % 2 == 0) {
					k /= 2;
				} else {
					k *= 3;
					k++;
				}
				if (idx > 0) {
					area.add((double) (num.get(idx - 1) + num.get(idx)) / 2);
				}
				idx++;
			}
			num.add(k);
			int n = num.size() - 1;
			area.add((double) (num.get(idx - 1) + num.get(idx)) / 2);
			for (int i = 0; i < ranges.length; i++) {
				int x = ranges[i][0];
				int y = Math.abs(ranges[i][1]);
				double tmp = 0.0;
				if (x > n - y) {
					answer[i] = -1.0;
				} else {
					for (int j = x; j < n - y; j++) {
						tmp += area.get(j);
					}
					answer[i] = tmp;
				}
			}
			return answer;
		}
	}
}
