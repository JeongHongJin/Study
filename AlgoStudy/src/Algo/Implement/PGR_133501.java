package Algo.Implement;

public class PGR_133501 {
	class Solution {
		public int solution(int distance, int[][] scope, int[][] times) {
			int answer = distance;
			for (int i = 0; i < scope.length; i++) {
				int a = Math.min(scope[i][0], scope[i][1]);
				int b = Math.max(scope[i][0], scope[i][1]);
				int x = times[i][0];
				int y = times[i][1];
				for (int k = a; k <= b; k++) {
					int tmp1 = k % (x + y);
					if (tmp1 == 0)
						tmp1 = k;
					if (tmp1 <= x) {
						answer = Math.min(k, answer);
						break;
					}
				}
			}
			return answer;
		}
	}
}
