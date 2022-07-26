package Algo.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1005 {
	static class Edge implements Comparable<Edge> {
		int to;
		int val;

		Edge(int to, int val) {
			this.to = to;
			this.val = val;
		}

		public int compareTo(Edge e) {
			return e.val - this.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			int[] dist = new int[n + 1];
			int[] indegree = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				dist[j] = Integer.parseInt(str[j - 1]);
			}
			boolean[] visit = new boolean[n + 1];
			ArrayList<Edge>[] map = new ArrayList[n + 1];
			for (int j = 0; j <= n; j++)
				map[j] = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				map[x].add(new Edge(y, dist[y]));
				indegree[y]++;
			}
			int end = Integer.parseInt(br.readLine());
			int answer = 0;
			Queue<Integer> pq = new LinkedList<>();
			for (int j = 1; j < indegree.length; j++) {
				if (indegree[j] == 0) {
					pq.offer(j);
				}
			}
			while (!pq.isEmpty()) {
				int now = pq.poll();
				for (Edge next : map[now]) {
					dist[next.to] = Math.max(dist[now] + next.val, dist[next.to]);
					indegree[next.to]--;
					if (indegree[next.to] == 0)
						pq.offer(next.to);
				}
			}
			sb.append(dist[end]).append('\n');
		}
		System.out.println(sb);
	}
}
