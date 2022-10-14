package Algo.Math;

import java.util.HashMap;

public class PGR_131701 {
	class Solution {
		public int solution(int[] elements) {
			int answer = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			int len = 1;
			for (int x = 0; x < elements.length; x++) {
				for (int i = 0; i < elements.length; i++) {
					int sum = 0;
					for (int j = i; j < i + len; j++) {
						sum += elements[j % elements.length];
					}
					map.put(sum, map.getOrDefault(sum, 0));
				}
				len++;
			}
			return map.size();
		}
	}
}
