package Algo.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PGR_42861 {
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

		public int solution(int n, int[][] costs) {
			int answer = 0;
			ArrayList<Edge>[] map = new ArrayList[n + 1];
			for (int i = 0; i < n; i++) {
				map[i] = new ArrayList<>();
			}
			for (int i = 0; i < costs.length; i++) {
				int x = costs[i][0];
				int y = costs[i][1];
				int val = costs[i][2];
				map[x].add(new Edge(y, val));
				map[y].add(new Edge(x, val));
			}

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0, 0));
			boolean[] visit = new boolean[n];
			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				if (visit[now.to])
					continue;
				visit[now.to] = true;
				answer += now.val;
				for (Edge next : map[now.to]) {
					if (visit[next.to])
						continue;
					pq.offer(new Edge(next.to, next.val));
				}
			}
			return answer;
		}
	}
}
