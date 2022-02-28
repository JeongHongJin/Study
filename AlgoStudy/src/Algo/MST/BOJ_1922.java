package Algo.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Prim방식
public class BOJ_1922 {
	static class Edge implements Comparable<Edge> {
		int to;
		int val;

		Edge(int to, int val) {
			this.to = to;
			this.val = val;
		}

		@Override
		public int compareTo(Edge e) { //오름차순
			return this.val - e.val;
		}

	}

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			map[start].add(new Edge(end, val));
			map[end].add(new Edge(start, val));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		boolean[] visit = new boolean[n + 1];
		long answer = 0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.to])
				continue;
			visit[now.to] = true;
			answer += now.val;
			for (Edge next : map[now.to]) {
				pq.offer(next);
			}
		}
		System.out.println(answer);
	}
}
