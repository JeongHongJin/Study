package Algo.BinaySearch;

public class PGR_64062 {
	class Solution {
		public int solution(int[] stones, int k) {
			int max = 0;
			for (int i = 0; i < stones.length; i++) {
				max = Math.max(max, stones[i]);
			}
			int start = 0;
			int end = max;
			while (start <= end) {
				int mid = (start + end) / 2;
				boolean flag = true;
				int cnt = 0;
				for (int i = 0; i < stones.length; i++) {
					if (stones[i] <= mid) {
						cnt++;
					} else {
						cnt = 0;
					}
					if (cnt == k) {
						flag = false;
						break;
					}
				}
				if (flag) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			return start;
		}
	}
}
