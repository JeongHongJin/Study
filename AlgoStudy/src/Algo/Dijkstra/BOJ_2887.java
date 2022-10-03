package Algo.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_2887 {
	static class Edge implements Comparable<Edge> {
		int idx;
		int x;
		int y;
		int z;
		long val;

		Edge(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		Edge(int x, long val) {
			this.x = x;
			this.val = val;
		}

		public int compareTo(Edge e) {
			return Long.compare(this.val, e.val);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Edge> list = new ArrayList<>();
		ArrayList<Edge>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int z = Integer.parseInt(str[2]);
			list.add(new Edge(i, x, y, z));
		}
		for (int idx = 0; idx < 3; idx++) {
			if (idx == 0) {
				Collections.sort(list, new Comparator<Edge>() {
					public int compare(Edge o1, Edge o2) {
						return o1.x - o2.x;
					}
				});
				for (int i = 1; i < n; i++) {
					Edge now = list.get(i - 1);
					Edge next = list.get(i);
					int x = now.x;
					int x2 = next.x;
					int min = Math.abs(x - x2);
					map[now.idx].add(new Edge(next.idx, min));
					map[next.idx].add(new Edge(now.idx, min));
				}
			} else if (idx == 1) {
				Collections.sort(list, new Comparator<Edge>() {
					public int compare(Edge o1, Edge o2) {
						return o1.y - o2.y;
					}
				});
				for (int i = 1; i < n; i++) {
					Edge now = list.get(i - 1);
					int y = now.y;
					Edge next = list.get(i);
					int y2 = next.y;
					int min = Math.abs(y - y2);
					map[now.idx].add(new Edge(next.idx, min));
					map[next.idx].add(new Edge(now.idx, min));
				}
			} else if (idx == 2) {
				Collections.sort(list, new Comparator<Edge>() {
					public int compare(Edge o1, Edge o2) {
						return o1.z - o2.z;
					}
				});
				for (int i = 1; i < n; i++) {
					Edge now = list.get(i - 1);
					int z = now.z;
					Edge next = list.get(i);
					int z2 = next.z;
					int min = Math.abs(z - z2);
					map[now.idx].add(new Edge(next.idx, min));
					map[next.idx].add(new Edge(now.idx, min));
				}
			}

		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		long answer = 0;
		boolean[] visit = new boolean[n + 1];
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (visit[now.x])
				continue;
			visit[now.x] = true;
			answer += now.val;
			for (Edge next : map[now.x]) {
				pq.offer(new Edge(next.x, next.val));
			}
		}
		System.out.println(answer);
	}
}
