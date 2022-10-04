package Algo.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BOJ_2211 {
	static class Node implements Comparable<Node> {
		int to;
		int val;

		Node(int to, int val) {
			this.to = to;
			this.val = val;
		}

		public int compareTo(Node n) {
			return this.val - n.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		ArrayList<Node>[] map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int val = Integer.parseInt(str[2]);
			map[x].add(new Node(y, val));
			map[y].add(new Node(x, val));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		int[] path = new int[n + 1];
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (Node next : map[now.to]) {
				if (dist[next.to] > dist[now.to] + next.val) {
					dist[next.to] = dist[now.to] + next.val;
					pq.offer(new Node(next.to, dist[next.to]));
					// 출발점 저장
					path[next.to] = now.to;
				}
			}
		}
		HashSet<String> set = new HashSet<>();
		for (int i = 2; i <= n; i++) {
			int end = i;
			// 도착지에서 출발지 찾기
			while (path[end] != 0) {
				set.add(end + " " + path[end]);
				end = path[end];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(set.size()).append('\n');
		for (String now : set) {
			sb.append(now).append('\n');
		}
		System.out.println(sb);
	}
}
