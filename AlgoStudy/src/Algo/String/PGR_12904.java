package Algo.String;

public class PGR_12904 {
	class Solution {
		public int solution(String s) {
			int answer = 1;
			for (int i = 1; i < s.length(); i++) {
				int tmp = 0;
				for (int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
					char c1 = s.charAt(j);
					char c2 = s.charAt(k);
					if (c1 == c2) {
						tmp += 2;
					} else {
						break;
					}
				}
				if (tmp == 0) {
					answer = Math.max(tmp, answer);
				} else {
					answer = Math.max(tmp + 1, answer);
				}
			}
			for (int i = 0; i < s.length(); i++) {
				int tmp = 0;
				for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
					char c1 = s.charAt(j);
					char c2 = s.charAt(k);
					if (c1 == c2) {
						tmp += 2;
					} else {
						break;
					}
				}
				answer = Math.max(tmp, answer);
			}
			return answer;
		}
	}
}
