package Algo.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;

public class Codility_Exercise4_FirstUnique {
	class Solution {
		public int solution(int[] A) {
			// write your code in Java SE 8
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> list = new ArrayList<>();
			int answer = -1;
			for (int i = 0; i < A.length; i++) {
				if (map.containsKey(A[i])) {
					map.put(A[i], map.get(A[i]) + 1);
				} else {
					map.put(A[i], 1);
					list.add(A[i]);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (map.get(list.get(i)) == 1) {
					answer = list.get(i);
					break;
				}
			}
			return answer;
		}
	}

}
