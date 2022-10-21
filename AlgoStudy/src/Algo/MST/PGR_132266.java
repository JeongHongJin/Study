package Algo.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PGR_132266 {
	class Solution {
		class Node implements Comparable<Node> {
			int to;
			int dis;

			Node(int to, int dis) {
				this.to = to;
				this.dis = dis;
			}

			public int compareTo(Node n) {
				return this.dis - n.dis;
			}
		}

		public int[] solution(int n, int[][] roads, int[] sources, int destination) {
			int[] answer = new int[sources.length];
			ArrayList<Node>[] map = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				map[i] = new ArrayList<>();
			}
			for (int i = 0; i < roads.length; i++) {
				int x = roads[i][0];
				int y = roads[i][1];
				map[x].add(new Node(y, 1));
				map[y].add(new Node(x, 1));
			}
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[destination] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(destination, 0));
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				for (Node next : map[now.to]) {
					if (dist[next.to] > dist[now.to] + next.dis) {
						dist[next.to] = dist[now.to] + next.dis;
						pq.offer(new Node(next.to, dist[next.to]));
					}
				}
			}
			for (int i = 0; i < sources.length; i++) {
				if (dist[sources[i]] == Integer.MAX_VALUE) {
					answer[i] = -1;
				} else {
					answer[i] = dist[sources[i]];
				}
			}
			return answer;
		}
	}
}
