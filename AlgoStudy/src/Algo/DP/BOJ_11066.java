package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제 헷갈린 이유 책은 연속으로 붙어 있어야한다.
public class BOJ_11066 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[n + 1];
			int[] sum = new int[n + 1];
			int[][] dp = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(str[i - 1]);
				// 모든 책의 합
				sum[i] = sum[i - 1] + arr[i];
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; i + j <= n; j++) {
					int next = i + j;
					dp[j][next] = Integer.MAX_VALUE;
					for (int k = j; k < next; k++) {
						dp[j][next] = Math.min(dp[j][next], dp[j][k] + dp[k + 1][next] + sum[next] - sum[j - 1]);
					}
				}
			}
			sb.append(dp[1][n]).append('\n');
		}
		System.out.println(sb);
	}
}
