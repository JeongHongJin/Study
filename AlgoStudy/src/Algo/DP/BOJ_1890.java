package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		long[][] dp = new long[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = map[i][j];
				if (tmp == 0)
					break;
				if (j + tmp < n)
					dp[i][j + tmp] += dp[i][j];
				if (i + tmp < n)
					dp[i + tmp][j] += dp[i][j];
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}
