package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(str[i]);
		}
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = -1;
		for (int i = 0; i <= n; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);
	}
}
