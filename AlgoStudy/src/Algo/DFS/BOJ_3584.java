package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_3584 {
	static int[] parent, depth;
	static ArrayList<Integer>[] list;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList[n + 1];
			parent = new int[n + 1];
			depth = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			boolean[] rootNode = new boolean[n + 1];
			for (int i = 0; i < n - 1; i++) {
				String[] str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				list[x].add(y);
				list[y].add(x);
				rootNode[y] = true;
			}
			String[] node = br.readLine().split(" ");
			int root = 0;
			for (int i = 1; i <= n; i++) {
				if (rootNode[i] == false) {
					root = i;
				}
			}
			dfs(root, 0, -1);

			int x = Integer.parseInt(node[0]);
			int y = Integer.parseInt(node[1]);
			int dx = depth[x];
			int dy = depth[y];
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
		for (int next : list[now]) {
			if (next != p) {
				dfs(next, d + 1, now);
			}
		}
	}
}
