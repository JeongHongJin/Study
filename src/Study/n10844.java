package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n + 1][10];
		long mod = 1000000000;
		// 첫 번째 자리수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개뿐이다.
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		// 두 번째 자릿수부터 n까지 탐색
		for (int i = 2; i <= n; i++) {
			// i번째 자릿수의 자릿값들을 탐색(0~9)
			for (int j = 0; j < 10; j++) {
				// 자릿 값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
				if (j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// 자릿값이 9 라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// 그외의 경우 이전 자릿수의 자릿값 +1,-1의 합
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		long answer = 0;
		// 각 자릿값마다의 경우의 수를 모두 더해준다.
		for (int i = 0; i < 10; i++) {
			answer += dp[n][i];
		}
		System.out.println(answer % mod);

	}
}
