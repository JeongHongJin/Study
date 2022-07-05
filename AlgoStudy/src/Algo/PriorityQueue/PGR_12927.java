package Algo.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGR_12927 {
	class Solution {
		public long solution(int n, int[] works) {
			long answer = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			long tmp = 0;
			for (int i = 0; i < works.length; i++) {
				pq.offer(works[i]);
				tmp += works[i];
			}
			if (tmp <= n)
				return 0;
			for (int i = 0; i < n; i++) {
				pq.offer(pq.poll() - 1);
			}
			while (!pq.isEmpty()) {
				answer += Math.pow(pq.poll(), 2);
			}
			return answer;
		}
	}
}
