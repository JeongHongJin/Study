package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
	static ArrayList<Integer>[] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[n];
		map = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {// 친구 관계 설정
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			if (result == 0)
				dfs(i, visit, 1);
		}
		System.out.println(result);
	}

	static void dfs(int start, boolean[] visit, int depth) {
		if (depth == 5) {// 친구 관계가 5명 이상 거쳐서 친구가 존재하는경우
			result = 1;
			return;
		}
		visit[start] = true;
		for (int next : map[start]) {
			if (!visit[next]) {
				dfs(next, visit, depth + 1);
			}
		}
		// 들린 노드를 다시 안들렸다고 복구
		visit[start] = false;
	}
}
