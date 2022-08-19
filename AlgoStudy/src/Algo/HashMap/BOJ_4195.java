package Algo.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_4195 {
	static int[] parent;
	static int[] level;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			level = new int[n * 2];
			parent = new int[n * 2];
			for (int i = 0; i < n * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			int idx = 0;
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if (!map.containsKey(str[0])) {
					map.put(str[0], idx++);
				}
				if (!map.containsKey(str[1])) {
					map.put(str[1], idx++);
				}
				sb.append(union(map.get(str[0]),map.get(str[1]))).append('\n');
			}
		}
		System.out.println(sb);
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static int union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
			level[x] += level[y];
			level[y] = 1;
		}
		return level[x];
	}
}
