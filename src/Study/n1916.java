package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1916 {
	// 가중치 비교
	static class Node implements Comparable<Node> {
		int n, w;

		Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		public int compareTo(Node o) {
			return w - o.w;
		}

	}

	static int N, M;
	static boolean[] visit;
	static int[] distance;
	static LinkedList<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new LinkedList[N + 1];
		visit = new boolean[N + 1];
		distance = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		Arrays.fill(distance, -1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Distance(start);
		System.out.println(distance[end]);
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
					// 가중치 비교 메소드
					if (distance[next.n] == -1 || distance[next.n] > distance[now.n] + next.w) {
						distance[next.n] = distance[now.n] + next.w;
						pq.offer(new Node(next.n, distance[next.n]));
					}
				}
			}
		}
	}
}
