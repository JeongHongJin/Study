package Algo.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PGR_76502 {
	class Solution {
		public int solution(String s) {
			int answer = 0;
			Queue<Character> q = new LinkedList<>();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				q.offer(s.charAt(i));
			}
			int cnt = 0;
			while (s.length() > cnt) {
				boolean flag = false;
				for (int i = 0; i < q.size(); i++) {
					char c = q.poll();
					q.offer(c);
					if (flag)
						continue;
					if (c == '(' || c == '{' || c == '[') {
						stack.push(c);
					} else {
						if (stack.isEmpty()) {
							flag = true;
							continue;
						}
						if (c == ')' && stack.peek() == '(') {
							stack.pop();
						} else if (c == '}' && stack.peek() == '{') {
							stack.pop();
						} else if (c == ']' && stack.peek() == '[') {
							stack.pop();
						} else {
							flag = true;
						}
					}
				}
				if (!stack.isEmpty())
					flag = true;
				if (!flag)
					answer++;
				q.offer(q.poll());
				cnt++;
			}

			return answer;
		}
	}
}
