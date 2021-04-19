package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		while (true) {
			String s = br.readLine();
			if (s.equals(".")) {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '[') {
					if (s.charAt(i) == '(') {
						stack.push(')');
					}
					if (s.charAt(i) == '[') {
						stack.push(']');
					}
				} else if ((s.charAt(i) == ')' || s.charAt(i) == ']')) {
					if (!stack.isEmpty()) {
						if (s.charAt(i) == ')' && stack.peek() == ')') {
							stack.pop();
						} else if (s.charAt(i) == ']' && stack.peek() == ']') {
							stack.pop();
						} else {
							flag = false;
						}
					} else {
						flag = false;
					}

				}
			}
			if (stack.isEmpty() && flag == true) {
				System.out.println("yes");
			} else {
				System.out.println("no");
				flag = true;
			}
			stack.clear();

		}
	}
}
