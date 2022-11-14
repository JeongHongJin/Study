package Algo.String;

public class PGR_133499 {
	class Solution {
		String[] str = { "aya", "ye", "woo", "ma" };
		String[] str2 = { "ayaaya", "yeye", "woowoo", "mama" };

		public int solution(String[] babbling) {
			int answer = 0;
			for (int i = 0; i < babbling.length; i++) {
				String s = babbling[i];
				boolean flag = false;
				for (int j = 0; j < str2.length; j++) {
					if (s.contains(str2[j])) {
						flag = true;
						break;
					}
				}
				if (flag)
					continue;
				for (int j = 0; j < 4; j++) {
					if (s.contains(str[j])) {
						s = s.replace(str[j], "-");
					}
				}
				boolean tmp = true;
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '-')
						continue;
					tmp = false;
				}
				if (tmp)
					answer++;
			}
			return answer;
		}
	}
}
