package Algo.String;

public class PGR_120956 {
	class Solution {
		public int solution(String[] babbling) {
			int answer = 0;
			for (int i = 0; i < babbling.length; i++) {
				String s = babbling[i];
				if (s.contains("ayaaya"))
					continue;
				if (s.contains("yeye"))
					continue;
				if (s.contains("woowoo"))
					continue;
				if (s.contains("mama"))
					continue;
				s = s.replace("aya", "");
				s = s.replace("ye", "");
				s = s.replace("woo", "");
				s = s.replace("ma", "");
				if (s.length() == 0) {
					answer++;
				}
			}
			return answer;
		}
	}
}
