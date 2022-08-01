package Algo.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1238 {
	static class Edge implements Comparable<Edge> {
		int to;
		int val;

		Edge(int to, int val) {
			this.to = to;
			this.val = val;
		}

		public int compareTo(Edge e) {
			return this.val - e.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int x = Integer.parseInt(str[2]);
		ArrayList<Edge>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int val = Integer.parseInt(str[2]);
			map[a].add(new Edge(b, val));
		}
		PriorityQueue<Edge> q = new PriorityQueue<>();
		int mod = 10000000;
		int[] dist = new int[n + 1];
		int[] dist2 = new int[n + 1];
		boolean[] visit = new boolean[n + 1];
		Arrays.fill(dist, mod);
		visit = new boolean[n + 1];
		q.offer(new Edge(x, 0));
		dist[x] = 0;
		int answer = 0;
		while (!q.isEmpty()) {
			Edge now = q.poll();
			if (visit[now.to])
				continue;
			visit[now.to] = true;
			for (Edge next : map[now.to]) {
				if (visit[next.to])
					continue;
				if (dist[next.to] > now.val + next.val) {
					dist[next.to] = now.val + next.val;
					q.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			q.offer(new Edge(i, 0));
			Arrays.fill(dist2, mod);
			dist2[i] = 0;
			visit = new boolean[n + 1];
			while (!q.isEmpty()) {
				Edge now = q.poll();
				if (visit[now.to])
					continue;
				visit[now.to] = true;
				for (Edge next : map[now.to]) {
					if (visit[next.to])
						continue;
					if (dist2[next.to] > now.val + next.val) {
						dist2[next.to] = now.val + next.val;
						q.offer(new Edge(next.to, dist2[next.to]));
					}
				}
			}
			dist[i] += dist2[x];
		}
		for (int i = 1; i <= n; i++) {
			if (dist[i] != mod) {
				answer = Math.max(answer, dist[i]);
			}
		}
		System.out.println(answer);

	}
}
