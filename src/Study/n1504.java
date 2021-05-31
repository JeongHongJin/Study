package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1504 {
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

	static int N, E;
	static int INF;
	static int[] distance;
	static boolean[] visit;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
			list[v].add(new Node(u, w));

		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int answer1 = 0;
		int answer2 = 0;
		INF = 10000 * (N - 1) + 1;

		answer1 += Search(1, v1);
		answer1 += Search(v1, v2);
		answer1 += Search(v2, N);

		answer2 += Search(1, v2);
		answer2 += Search(v2, v1);
		answer2 += Search(v1, N);
		int answer = Math.min(answer1, answer2);
		if (answer >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static int Search(int start, int end) {
		distance = new int[N + 1];
		visit = new boolean[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visit[now.n]) {
				visit[now.n] = true;
				for (Node next : list[now.n]) {
					if (distance[next.n] > distance[now.n] + next.weight) {
						distance[next.n] = distance[now.n] + next.weight;
						pq.offer(new Node(next.n, distance[next.n]));
					}
				}
			}
		}
		return distance[end];
	}
}
