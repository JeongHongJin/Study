package Algo.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		ArrayList<Integer>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		int[] degree = new int[n + 1];
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			int before = Integer.parseInt(str[1]);
			for (int j = 2; j < str.length; j++) {
				int y = Integer.parseInt(str[j]);
				map[before].add(y);
				degree[y]++;
				before = y;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append('\n');
			list.add(now);
			for (int next : map[now]) {
				degree[next]--;
				if (degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		if (list.size() != n) {
			sb.setLength(0);
			sb.append(0);
		}
		System.out.println(sb);
	}
}
