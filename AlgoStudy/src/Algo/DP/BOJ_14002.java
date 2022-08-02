package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		dp[0] = 1;
		int lis = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					lis = Math.max(lis, dp[i]);
				}
			}
		}
		sb.append(lis).append('\n');
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == lis) {
				stack.push(arr[i]);
				lis--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		System.out.println(sb);
	}
}
