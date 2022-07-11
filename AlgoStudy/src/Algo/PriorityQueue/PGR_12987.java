package Algo.PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PGR_12987 {
	class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;
			Arrays.sort(A);
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < B.length; i++)
				pq.offer(B[i]);
			for (int i = A.length - 1; i >= 0; i--) {
				if (pq.isEmpty())
					break;
				int tmp = pq.peek();
				if (tmp > A[i]) {
					answer++;
					pq.poll();
				}
			}
			return answer;
		}
	}
}
