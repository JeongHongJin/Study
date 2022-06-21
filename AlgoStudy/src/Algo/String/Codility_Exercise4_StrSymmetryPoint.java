package Algo.String;

public class Codility_Exercise4_StrSymmetryPoint {
	class Solution {
		public int solution(String S) {
			int answer = 0;
			if (S.length() % 2 == 1)
				for (int i = 0; i < S.length() / 2 + 1; i++) {
					if (S.charAt(i) != S.charAt(S.length() - 1 - i)) {
						answer = -1;
						break;
					} else {
						answer = i;
					}
				}
			else {
				return -1;
			}
			return answer;
		}
	}
}
