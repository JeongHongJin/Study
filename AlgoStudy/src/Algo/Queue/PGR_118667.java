package Algo.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PGR_118667 {
	class Solution {
		public int solution(int[] queue1, int[] queue2) {
			int answer = 0;
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			long sum1 = 0;
			long sum2 = 0;
			for (int i = 0; i < queue1.length; i++) {
				q1.offer(queue1[i]);
				q2.offer(queue2[i]);
				sum1 += queue1[i];
				sum2 += queue2[i];
			}
			while (sum1 != sum2) {
				if (answer > 1000000)
					return -1;
				if (sum1 > sum2) {
					int now = q1.poll();
					q2.offer(now);
					sum1 -= now;
					sum2 += now;
				} else {
					int now = q2.poll();
					q1.offer(now);
					sum1 += now;
					sum2 -= now;
				}
				answer++;
			}
			return answer;
		}
	}
}
