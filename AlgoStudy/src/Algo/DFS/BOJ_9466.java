package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9466 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[n + 1];
			boolean[] visit = new boolean[n + 1];
			boolean[] cycle = new boolean[n + 1];
			answer = 0;
			for (int i = 0; i < n; i++) {
				arr[i + 1] = Integer.parseInt(str[i]);
			}
			for (int i = 1; i <= n; i++) {
				dfs(i, arr, visit, cycle);
			}
			sb.append(n - answer).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int now, int[] arr, boolean[] visit, boolean[] cycle) {
		visit[now] = true;
		int next = arr[now];

		if (!visit[next]) {// 방문한적 없으면 방문
			dfs(next, arr, visit, cycle);
		} else {
			if (!cycle[next]) {
				// 혼자만 팀 하는 경우
				answer++;
				while (next != now) {// 혼자팀하는데 다른팀원도 끼는경우
					answer++;
					next = arr[next];
				}
			}
		}
		cycle[now] = true;
	}

}
