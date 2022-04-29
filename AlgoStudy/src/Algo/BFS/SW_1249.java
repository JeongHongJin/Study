package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_1249 {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int val;

		Node(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		public int compareTo(Node n) {
			return this.val - n.val;
		}
	}

	static int n;
	static int answer = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			answer = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			Search(0, 0);
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static void Search(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		boolean[][] visit = new boolean[n][n];
		visit[x][y] = true;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.x == n - 1 && now.y == n - 1) {
				answer = now.val;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (visit[nx][ny])
					continue;
				pq.offer(new Node(nx, ny, now.val + map[nx][ny]));
				visit[nx][ny] = true;
			}
		}
	}
}
