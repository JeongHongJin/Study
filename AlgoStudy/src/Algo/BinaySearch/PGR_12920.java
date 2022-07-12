package Algo.BinaySearch;

public class PGR_12920 {
	class Solution {
		public int solution(int n, int[] cores) {
			int answer = 0;
			int start = 0;
			int end = n * cores[0]; // 코어가 제일 많이 돌아가는 경우
			int time = 0;
			int min = 0;
			while (start <= end) {
				int mid = (start + end) / 2;
				int sum = cores.length;
				if (mid != 0) {
					for (int i = 0; i < cores.length; i++) {
						sum += mid / cores[i];
					}
				}

				if (sum < n) {
					start = mid + 1;
				} else {
					end = mid - 1;
					time = mid;
					min = sum;
				}
			}
			min -= n; // 처리한 작업량과 n의 차이
			for (int i = cores.length - 1; i >= 0; i--) {
				if (time % cores[i] == 0) {
					if (min == 0) {
						answer = i + 1;
						break;
					}
					min--;
				}
			}
			return answer;
		}
	}
}
