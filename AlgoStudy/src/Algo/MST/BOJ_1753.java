package Algo.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	static class Edge implements Comparable<Edge> {
		int end;
		int val;

		Edge(int end, int val) {
			this.end = end;
			this.val = val;
		}

		@Override
		public int compareTo(Edge e) {
			return this.val - e.val;
		}
	}

	static int v, e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] map = new ArrayList[v + 1];
		int[] dist = new int[v + 1];
		Arrays.fill(dist, 1000000);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i <= v; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			map[x].add(new Edge(y, val));
		}
		boolean[] visit = new boolean[v + 1];
		pq.offer(new Edge(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.end])
				continue;
			visit[now.end] = true;
			for (Edge next : map[now.end]) {
				if (dist[next.end] > dist[now.end] + next.val) {
					dist[next.end] = dist[now.end] + next.val;
					pq.offer(new Edge(next.end, dist[next.end]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == 1000000) {
				sb.append("INF").append('\n');
			} else {
				sb.append(dist[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
