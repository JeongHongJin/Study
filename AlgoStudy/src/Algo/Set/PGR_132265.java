package Algo.Set;

import java.util.HashSet;

public class PGR_132265 {
	class Solution {
		public int solution(int[] topping) {
			int answer = 0;
			int[] score = new int[10001];
			HashSet<Integer> left = new HashSet<>();
			HashSet<Integer> right = new HashSet<>();
			for (int i = 0; i < topping.length; i++) {
				right.add(topping[i]);
				score[topping[i]]++;
			}
			for (int i = 0; i < topping.length; i++) {
				left.add(topping[i]);
				if (score[topping[i]] == 1) {
					score[topping[i]]--;
					right.remove(topping[i]);
				} else {
					score[topping[i]]--;
				}
				if (left.size() == right.size()) {
					answer++;
				}
			}
			return answer;
		}
	}
}
