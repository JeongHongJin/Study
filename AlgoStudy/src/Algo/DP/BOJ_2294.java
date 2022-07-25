package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[] dp = new int[k + 1];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= k; i++)
			dp[i] = Integer.MAX_VALUE - 1;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j - arr[i]] + 1, dp[j]);
			}
		}
		if (dp[k] == Integer.MAX_VALUE - 1)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}
