package Algo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			stack.push(c);
			if (stack.size() >= bomb.length()) {
				boolean flag = true;
				for (int j = 0; j < bomb.length(); j++) {
					char c1 = stack.get(stack.size() - bomb.length() + j);
					char c2 = bomb.charAt(j);
					if (c1 != c2) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		if (stack.size() == 0)
			System.out.println("FRULA");
		else {
			for (char c : stack) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}
}
