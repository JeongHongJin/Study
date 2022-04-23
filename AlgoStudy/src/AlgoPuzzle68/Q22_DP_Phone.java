package AlgoPuzzle68;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q22_DP_Phone {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		System.out.println(Arrays.toString(dp));
	}
}
