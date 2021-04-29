package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}
		for (int i = 0; i < T; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}
