package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[3];
		int[] dp2 = new int[3];
		int[] arr = new int[3];
		int[] arr2 = new int[3];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[j] = Integer.parseInt(str[j]);
				arr2[j] = Integer.parseInt(str[j]);
			}
			if (i == 0) {
				for (int j = 0; j < 3; j++) {
					dp[j] = arr[j];
					dp2[j] = arr[j];
				}
				continue;
			}
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					arr[j] += Math.max(dp[j], dp[j + 1]);
				} else if (j == 2) {
					arr[j] += Math.max(dp[j], dp[j - 1]);
				} else {
					arr[j] += Math.max(Math.max(dp[j], dp[j - 1]), dp[j + 1]);
				}
			}
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					arr2[j] += Math.min(dp2[j], dp2[j + 1]);
				} else if (j == 2) {
					arr2[j] += Math.min(dp2[j], dp2[j - 1]);
				} else {
					arr2[j] += Math.min(Math.min(dp2[j], dp2[j - 1]), dp2[j + 1]);
				}
			}
			for (int j = 0; j < 3; j++) {
				dp[j] = arr[j];
				dp2[j] = arr2[j];
			}
		}
		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		int max = -1;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp2[i]);
			max = Math.max(max, dp[i]);
		}
		sb.append(max).append(" ").append(min);
		System.out.println(sb);
	}
}
