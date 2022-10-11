package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_16928 {
	static class Node implements Comparable<Node> {
		int x;
		int cnt;

		Node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

		public int compareTo(Node n) {
			return this.cnt - n.cnt;
		}
	}

	static int n, m;
	static int answer = 0;
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		for (int i = 0; i < n + m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map.put(x, y);
		}
		bfs(1);
		System.out.println(answer);
	}

	static void bfs(int x) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(1, 0));
		boolean[] visit = new boolean[101];
		visit[1] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.x == 100) {
				answer = now.cnt;
				return;
			}
			for (int i = 1; i <= 6; i++) {
				int nx = now.x + i;
				if (nx > 100)
					continue;
				if (visit[nx])
					continue;
				if (map.containsKey(nx)) {
					nx = map.get(nx);
				}
				q.offer(new Node(nx, now.cnt + 1));
				visit[nx] = true;
			}
		}
	}
}
