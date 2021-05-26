package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1753 {
	// 가중치를 비교한다
	static class Node implements Comparable<Node> {
		int n, weight;

		Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int V, E, K;
	static LinkedList<Node>[] list;
	static int[] distance;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visit = new boolean[V + 1];
		list = new LinkedList[V + 1];
		distance = new int[V + 1];
		Arrays.fill(distance, -1);
		for (int i = 1; i <= V; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		Distance(K);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == -1) {
				sb.append("INF").append('\n');
			} else {
				sb.append(distance[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	static void Distance(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (!visit[now.n]) {
				visit[now.n] = true;
				for (Node next : list[now.n]) {
					if (distance[next.n] == -1 || distance[next.n] > distance[now.n] + next.weight) {
						distance[next.n] = distance[now.n] + next.weight;
						// 정점 추가, 거리 추가
						pq.offer(new Node(next.n, distance[next.n]));
					}
				}
			}
		}
	}

}
