package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1939 {
	static class Node {
		int n, weight;

		Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
	}

	static ArrayList<Node>[] list;
	static int n;
	static int maxWeight, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
			list[v].add(new Node(u, w));
			maxWeight = Math.max(maxWeight, w);
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		Search(v1,v2);
		System.out.println(max);
	}
	// 이진탐색
	static void Search(int start, int end) {
		int left = 1;
		int right = maxWeight;
		boolean[] visit = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		while (left <= right) {
			int mid = (left + right) / 2;
			q.offer(start);
			visit[start] = true;
			boolean exist = possibleRoute(q, visit, mid, end);
			if (exist) {
				max = Math.max(max, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			q.clear();
			Arrays.fill(visit, false);
		}
	}

	static boolean possibleRoute(Queue<Integer> q, boolean[] visit, int mid, int end) {
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Node next : list[now]) {
				if (next.weight >= mid) {
					if (now == end) {
						return true;
					}
					if (!visit[next.n]) {
						visit[next.n] = true;
						q.offer(next.n);
					}
				}
			}
		}
		return false;
	}
}
