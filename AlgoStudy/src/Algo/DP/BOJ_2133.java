package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		if (n > 1) {
			dp[2] = 3;
			// 짝수인 경우만 가능
			for (int i = 4; i <= n; i += 2) {
				// 3xn 타일 이므로 양옆 케이스 +2
				dp[i] = (dp[i - 2] * 3) + 2;
				for (int j = 1; j <= (i - 4) / 2; j++) {
					// 위아래 뒤집기
					dp[i] += (dp[2 * j] * 2);
				}
			}
		}
		if (n % 2 != 0)
			System.out.println(0);
		else
			System.out.println(dp[n]);
	}
}
