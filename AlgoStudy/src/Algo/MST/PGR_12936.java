package Algo.MST;

import java.util.ArrayList;

public class PGR_12936 {
	class Solution {
		public int[] solution(int n, long k) {
			int[] answer = new int[n];
			int[] arr = new int[n];
			ArrayList<Integer> list = new ArrayList<>();
			long sum = 1;
			for (int i = 1; i <= n; i++) {
				sum *= i;
				list.add(i);
			}
			int idx = 0;
			long end = k - 1;
			while (n > 0) {
				sum /= n;
				answer[idx++] = list.get((int) (end / sum));
				list.remove((int) (end / sum));
				end %= sum;
				n--;
			}
			return answer;
		}
	}
}
