package Algo.DFS;

import java.util.ArrayList;
import java.util.HashMap;

public class PGR_43163 {
	class Solution {
		int answer = Integer.MAX_VALUE;
		ArrayList<String>[] map;
		boolean[] visit;
		HashMap<String, Integer> map2 = new HashMap<>();

		public int solution(String begin, String target, String[] words) {
			answer = Integer.MAX_VALUE;
			visit = new boolean[words.length + 1];
			map = new ArrayList[words.length + 1];
			String[] words2 = new String[words.length + 1];
			for (int i = 0; i < words.length; i++) {
				words2[i] = words[i];
			}
			words2[words.length] = begin;
			for (int i = 0; i < map.length; i++) {
				map[i] = new ArrayList<>();
			}
			map2.put(begin, words.length);
			for (int i = 0; i < words.length; i++) {
				int tmp2 = 0;
				map2.put(words[i], i);
				for (int k = 0; k < target.length(); k++) {
					if (words[i].charAt(k) != begin.charAt(k))
						tmp2++;
				}
				if (tmp2 == 1) {
					map[words.length].add(words[i]);
				}
			}
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length; j++) {
					int tmp = 0;
					for (int k = 0; k < target.length(); k++) {
						if (words[i].charAt(k) != words[j].charAt(k))
							tmp++;
					}
					if (tmp == 1) {
						map[i].add(words[j]);
					}
				}
			}
			for (int i = 0; i < words.length; i++) {
				if (target.equals(words[i])) {
					dfs(begin, target, 0, words2);
					return answer;
				}
			}
			return 0;
		}

		public void dfs(String begin, String target, int depth, String[] words) {
			if (begin.equals(target)) {
				answer = Math.min(answer, depth);
				return;
			}
			int i = map2.get(begin);
			if (visit[i])
				return;
			visit[i] = true;
			for (String s : map[map2.get(begin)]) {
				dfs(s, target, depth + 1, words);
			}
		}
	}
}
