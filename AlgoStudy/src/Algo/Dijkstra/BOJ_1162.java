package Algo.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1162 {
	static class Edge implements Comparable<Edge> {
		int to;
		int cnt;
		long val;

		Edge(int to, int cnt, long val) {
			this.to = to;
			this.cnt = cnt;
			this.val = val;
		}

		public int compareTo(Edge e) {
			return Long.compare(this.val, e.val);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		ArrayList<Edge>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int val = Integer.parseInt(str[2]);
			map[x].add(new Edge(y, 0, val));
			map[y].add(new Edge(x, 0, val));
		}
		long[][] dist = new long[n + 1][k + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0, 0));
		for (int i = 0; i <= n; i++)
			Arrays.fill(dist[i], 10000000000l);
		dist[1][0] = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (now.val > dist[now.to][now.cnt])
				continue;
			for (Edge next : map[now.to]) {
				if (now.cnt < k && dist[next.to][now.cnt + 1] > dist[now.to][now.cnt]) {
					dist[next.to][now.cnt + 1] = dist[now.to][now.cnt];
					pq.offer(new Edge(next.to, now.cnt + 1, dist[next.to][now.cnt + 1]));
				}
				if (dist[next.to][now.cnt] > dist[now.to][now.cnt] + next.val) {
					dist[next.to][now.cnt] = dist[now.to][now.cnt] + next.val;
					pq.offer(new Edge(next.to, now.cnt, dist[next.to][now.cnt]));
				}
			}
		}
		long min = Long.MAX_VALUE;

		for (int i = 0; i <= k; i++) {
			min = Math.min(min, dist[n][i]);
		}
		System.out.println(min);
	}
}
