package Algo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
	static String s, num, operation;
	static int len1, len2, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		s = br.readLine();
		num = s.replaceAll("[^0-9]", "");
		operation = s.replaceAll("[0-9]", "");
		len1 = num.length();
		len2 = operation.length();
		dfs(num.charAt(0) - '0', 0);
		System.out.println(answer);
	}

	static void dfs(int sum, int depth) {
		if (depth >= len2) {
			answer = Math.max(answer, sum);
			return;
		}
		char c = operation.charAt(depth);
		int a = num.charAt(depth + 1) - '0';
		int sum1 = calc(c, sum, a);
		// 현재 계산
		dfs(sum1, depth + 1);
		// 다음꺼 계산
		if (depth + 1 < len2) {
			char c2 = operation.charAt(depth + 1);
			int b = num.charAt(depth + 2) - '0';
			int sum2 = calc(c2, a, b);
			dfs(calc(c, sum, sum2), depth + 2);
		}
	}

	static int calc(char c, int n1, int n2) {
		switch (c) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		}
		return -1;
	}
}
