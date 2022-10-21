package Algo.Math;

public class PGR_132267 {
	class Solution {
		public int solution(int a, int b, int n) {
			int answer = 0;
			while (true) {
				if (n < a) {
					break;
				}
				int coke = n / a;
				n %= a;
				answer += (coke * b);
				n += (coke * b);

			}
			return answer;
		}
	}
}
