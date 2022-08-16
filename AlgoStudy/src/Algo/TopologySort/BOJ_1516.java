package Algo.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n + 1];
		int[] degree = new int[n + 1];
		ArrayList<Integer>[] map = new ArrayList[n + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			time[i] = x;
			for (int j = 1; j < str.length - 1; j++) {
				int y = Integer.parseInt(str[j]);
				map[y].add(i);
				degree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : map[now]) {
				degree[next]--;
				dist[next] = Math.max(dist[next], dist[now] + time[now]);
				if (degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		for (int i = 1; i <= n; i++)
			sb.append(dist[i] + time[i]).append('\n');
		System.out.println(sb);
	}
}
