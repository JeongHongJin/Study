package Algo.Regex;

import java.util.regex.Pattern;

public class PGR_60060 {
	class Solution {
		public int[] solution(String[] words, String[] queries) {
			int[] answer = new int[queries.length];
			for (int i = 0; i < queries.length; i++) {
				String s = queries[i].replace("?", ".");
				int len = s.length();
				if (s.charAt(0) == '.' && (s.charAt(len - 1) >= 'z' && s.charAt(len - 1) <= 'a')) {
					continue;
				}
				if (s.charAt(len - 1) == '.' && (s.charAt(0) >= 'z' && s.charAt(0) <= 'a'))
					continue;
				if (len - s.replace(".", "").length() != len && s.charAt(0) == '.' && s.charAt(len - 1) == '.') {
					continue;
				}
				// 일치하는 경우 체크
				for (int j = 0; j < words.length; j++) {
					if (words[j].length() == s.length())
						if (Pattern.matches(s, words[j])) {
							answer[i]++;
						}
				}
			}
			return answer;
		}
	}
}
