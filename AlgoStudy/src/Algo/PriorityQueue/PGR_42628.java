package Algo.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGR_42628 {
	class Solution {
		public int[] solution(String[] operations) {
			int[] answer = new int[2];
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> min = new PriorityQueue<>();
			for (int i = 0; i < operations.length; i++) {
				String[] tmp = operations[i].split(" ");
				int num = Integer.parseInt(tmp[1]);
				if (tmp[0].equals("I")) {
					pq.offer(num);
					min.offer(num);
					max.offer(num);
				} else if (tmp[0].equals("D")) {
					if (pq.isEmpty()) {
						continue;
					}
					pq.poll();
					if (num == 1) {
						max.poll();
					} else {
						min.poll();
					}
					if (pq.isEmpty()) {
						max.clear();
						min.clear();
					}
				}
			}
			if (pq.isEmpty())
				return answer;
			answer[0] = max.poll();
			answer[1] = min.poll();
			return answer;
		}
	}
}
