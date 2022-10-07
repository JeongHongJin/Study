package Algo.Implement;

import java.util.ArrayList;
import java.util.Collections;

public class PGR_131130 {
	class Solution {
		public int solution(int[] cards) {
			int answer = 0;
			boolean[] visit = new boolean[cards.length];
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < cards.length; i++) {
				int idx = i;
				int tmp = 0;
				while (!visit[idx]) {
					visit[idx] = true;
					idx = cards[idx] - 1;
					tmp++;
				}
				if (tmp > 0) {
					list.add(tmp);
				}
			}
			Collections.sort(list);
			if (list.size() == 1) {
				return 0;
			}
			return list.get(list.size() - 1) * list.get(list.size() - 2);
		}
	}
}
