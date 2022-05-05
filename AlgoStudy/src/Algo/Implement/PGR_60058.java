package Algo.Implement;

import java.util.Stack;

public class PGR_60058 {
	class Solution {
		public String solution(String p) {
			StringBuilder sb = new StringBuilder();
			if (check(p))
				return p;
			if (p.length() == 0)
				return p;
			int left = 0;
			int right = 0;
			int idx = 0;
			String u = "";
			String v = "";
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == '(') {
					left++;
				} else {
					right++;
				}
				if (left == right) {
					idx = i + 1;
					break;
				}
			}
			u = p.substring(0, idx);
			v = p.substring(idx);
			if (check(u)) {
				return u + solution(v);
			} else {
				sb.append('(');
				sb.append(solution(v));
				sb.append(')');
				for (int i = 1; i < u.length() - 1; i++) {
					if (u.charAt(i) == ')') {
						sb.append('(');
					} else {
						sb.append(')');
					}
				}
				return sb.toString();
			}
		}

		public boolean check(String u) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(') {
					stack.push(')');
				} else {
					if (stack.isEmpty())
						return false;
					stack.pop();
				}
			}
			if (!stack.isEmpty())
				return false;
			return true;
		}
	}
}
