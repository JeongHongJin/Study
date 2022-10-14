package Algo.Implement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PGR_131704 {
	class Solution {
		public int solution(int[] order) {
			int answer = 0;
			Queue<Integer> q = new LinkedList<>();
			Stack<Integer> stack = new Stack<>();
			for (int i = 1; i <= order.length; i++) {
				q.offer(i);
			}
			int idx = 0;
			int cnt = 0;
			boolean flag = false;
			while (true) {
				if (flag)
					break;
				if (q.isEmpty() && stack.isEmpty())
					break;
				while (!q.isEmpty()) {
					int now = q.peek();
					if (now == order[idx]) {
						stack.push(q.poll());
						break;
					} else {
						stack.push(q.poll());
					}
				}
				while (!stack.isEmpty()) {
					int now = stack.peek();
					if (now == order[idx]) {
						stack.pop();
						answer++;
						idx++;
					} else {
						if (q.isEmpty()) {
							flag = true;
						}
						break;
					}
				}
			}

			return answer;
		}
	}
}
