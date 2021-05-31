package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class n2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] wire = new int[n][2];
		int[] dp = new int[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		// A전봇대를 기준으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			public int compare(int[] n1, int[] n2) {
				return n1[0] - n2[0];
			}
		});

		for (int i = 0; i < dp.length; i++) {
			// 최소 개수로 초기화
			dp[i] = 1;
			// i 번째 전봇대를 기준으로 이전의 전봇대들
			// 전선을 연결하기 위해 탐색
			// i번째 연결된 B전봇대는 탐색할 j번째 전봇대에 연결된
			// B전봇대보다 값이 커야한다.
			for (int j = 0; j < i; j++) {
				if (wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		// 전체 개수 - 설치 가능한 전깃줄
		// 최소 철거 개수
		System.out.println(n - max);
	}
}
