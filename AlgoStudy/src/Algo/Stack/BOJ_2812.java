package Algo.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		String s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			while (cnt < k && !stack.isEmpty() && stack.peek() < num) {
				stack.pop();
				cnt++;
			}
			stack.push(num);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n - k; i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb);
	}
}
