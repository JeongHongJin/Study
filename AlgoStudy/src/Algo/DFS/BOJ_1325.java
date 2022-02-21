package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1325 {
	static ArrayList<Integer>[] map;
	static int[] result;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1];
		result = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A].add(B);
		}
		for (int i = 1; i <= N; i++) {
			boolean[] visit = new boolean[N + 1];
			dfs(i, visit);
		}
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		for (int i = 1; i <= N; i++) {
			if (result[i] == max)
				sb.append(i).append(' ');
		}
		System.out.println(sb);
	}

	static void dfs(int start, boolean[] visit) {
		visit[start] = true;
		for (int i : map[start]) {
			if (!visit[i]) {
				result[i]++;
				dfs(i, visit);
			}
		}
	}
}
