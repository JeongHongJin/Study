package Algo.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijstra
public class BOJ_1916 {
	static class Edge implements Comparable<Edge> {
		int to;
		int val;

		Edge(int to, int val) {
			this.to = to;
			this.val = val;
		}

		@Override
		public int compareTo(Edge e) {
			return this.val - e.val;
		}
	}

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
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
		}
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[n + 1]; // 최소 비용 초기화
		boolean[] visit = new boolean[n + 1]; // 방문 체크
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대로 비용을 올려둠
		pq.offer(new Edge(startCity, 0)); // 시작 노드 셋팅
		dist[startCity] = 0; // 시작 노드 셋팅
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.to])
				continue;
			visit[now.to] = true;
			for (Edge next : map[now.to]) {
				if (dist[next.to] > dist[now.to] + next.val) { // 다음 방문 노드 비용 감소하는경우만 pq에 추가
					dist[next.to] = dist[now.to] + next.val;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		System.out.println(dist[endCity]);
	}
}
