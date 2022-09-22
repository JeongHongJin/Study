package Algo.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGR_72413 {
	class Solution {
		class Edge implements Comparable<Edge> {
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

		ArrayList<Edge>[] map;

		public int solution(int n, int s, int a, int b, int[][] fares) {
			int answer = Integer.MAX_VALUE;
			map = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				map[i] = new ArrayList<>();
			}
			for (int i = 0; i < fares.length; i++) {
				int x = fares[i][0];
				int y = fares[i][1];
				int val = fares[i][2];
				map[x].add(new Edge(y, val));
				map[y].add(new Edge(x, val));
			}

			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			int[] dist2 = new int[n + 1];
			Arrays.fill(dist2, Integer.MAX_VALUE);
			int[] dist3 = new int[n + 1];
			Arrays.fill(dist3, Integer.MAX_VALUE);
			dist = dij(s, dist);
			dist2 = dij(a, dist2);
			dist3 = dij(b, dist3);

			for (int i = 1; i <= n; i++) {
				answer = Math.min(answer, dist[i] + dist2[i] + dist3[i]);
			}
			return answer;
		}

		public int[] dij(int s, int[] dist) {
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(s, 0));
			dist[s] = 0;

			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				if (now.val > dist[now.to])
					continue;
				for (Edge next : map[now.to]) {
					if (dist[next.to] > dist[now.to] + next.val) {
						dist[next.to] = dist[now.to] + next.val;
						pq.offer(new Edge(next.to, dist[next.to]));
					}
				}
			}
			return dist;
		}
	}
}
