package Algo.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11437 {
	static ArrayList<Integer>[] map;
	static int[] parent;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x].add(y);
			map[y].add(x);
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		parent = new int[n + 1];
		depth = new int[n + 1];

		dfs(1, 0, -1);

		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);

			int dx = depth[x];
			int dy = depth[y];
			// 공통조상의 깊이 x가 깊으면 x--;
			while (dx > dy) {
				x = parent[x];
				dx--;
			}
			// 공통조상의 깊이 y가 깊으면 y--;
			while (dy > dx) {
				y = parent[y];
				dy--;
			}
			// 길이 같아졌지만 x y가 다른경우 최종 공통조상 찾기
			while (x != y) {
				x = parent[x];
				y = parent[y];
			}
			sb.append(x).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int now, int d, int p) {
		depth[now] = d;
		parent[now] = p;
		for (int next : map[now]) {
			if (next != p) {
				dfs(next, d + 1, now);
			}
		}
	}
}
