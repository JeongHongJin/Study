package Algo.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PGR_118669 {
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

		public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
			int[] answer = new int[2];
			answer[1] = Integer.MAX_VALUE;
			HashMap<Integer, Integer> gMap = new HashMap<>();
			HashMap<Integer, Integer> sMap = new HashMap<>();
			ArrayList<Edge>[] elist = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				elist[i] = new ArrayList<>();
			}
			for (int i = 0; i < paths.length; i++) {
				int x = paths[i][0];
				int y = paths[i][1];
				int val = paths[i][2];
				elist[x].add(new Edge(y, val));
				elist[y].add(new Edge(x, val));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < gates.length; i++) {
				gMap.put(gates[i], 0);
			}
			for (int i = 0; i < summits.length; i++) {
				sMap.put(summits[i], 0);
			}
			Arrays.sort(summits);
			for (int i = 0; i < summits.length; i++) {
				pq.offer(new Edge(summits[i], 0));
				boolean[] visit = new boolean[n + 1];
				int max = 0;
				while (!pq.isEmpty()) {
					Edge now = pq.poll();
					if (visit[now.to])
						continue;
					visit[now.to] = true;
					max = Math.max(now.val, max);
					if (gMap.containsKey(now.to)) {
						if (answer[1] > max) {
							answer[0] = summits[i];
							answer[1] = max;
						}
						pq.clear();
						continue;
					}
					for (Edge next : elist[now.to]) {
						if (sMap.containsKey(next.to)) {
							continue;
						}
						pq.offer(new Edge(next.to, next.val));
					}
				}
			}

			return answer;
		}
	}
}
