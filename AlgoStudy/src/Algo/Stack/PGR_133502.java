package Algo.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PGR_133502 {
	class Solution {
		public int solution(int[] ingredient) {
			int answer = 0;
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> q2 = new LinkedList<>();
			for (int i = 0; i < ingredient.length; i++) {
				stack.push(ingredient[i]);
				if (stack.peek() == 1 && stack.size() > 3) {
					int a = stack.pop();
					int b = stack.pop();
					int c = stack.pop();
					int d = stack.pop();
					if (a == 1 && b == 3 && c == 2 && d == 1) {
						answer++;
					} else {
						stack.push(d);
						stack.push(c);
						stack.push(b);
						stack.push(a);
					}
				}
			}
			return answer;
		}
	}
}
