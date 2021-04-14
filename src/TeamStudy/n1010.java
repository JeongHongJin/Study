package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1010 {

	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(com(M, N)).append('\n');
		}
		System.out.println(sb);
	}

	// combination 구현 함수
	static int com(int n, int m) {
		// 이미 탐색한 경우 바로 반환
		System.out.println(n);
		if (dp[n][m] > 0) {
			return dp[n][m];
		}
		// 건너는 점 같은경우 또는 서쪽다리 N개 다리끼리 안겹치게
		if (n == m || m == 0) {
			return dp[n][m] = 1;
		}
		// 최대 한개만 다리연결가능
		return dp[n][m] = com(n - 1, m - 1) + com(n - 1, m);
	}
}
