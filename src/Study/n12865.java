package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] dp = new int[n + 1][K + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			// 1부터 최대 무게까지 확인해본다.
			for (int j = 1; j <= K; j++) {
				// 무게를 더 담을 수 없는 경우
				if (w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// 최대 가치에서 더한다.
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[n][K]);
	}
}
