package Algo.Math;

public class PGR_12923 {
	class Solution {
		public int[] solution(long begin, long end) {
			int[] answer = {};
			int dis = (int) (end - begin + 1);
			answer = new int[dis];
			for (int i = (int) begin; i <= (int) end; i++) {
				boolean flag = false;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0 && (i / j) <= 10000000) {// 10,000,000블록넘어가는경우
						flag = true;
						answer[i - (int) begin] = i / j;
						break;
					}
				}
				if (i == 1)
					flag = true;
				if (!flag) {
					answer[i - (int) begin] = 1;
				}
			}

			return answer;
		}
	}
}
