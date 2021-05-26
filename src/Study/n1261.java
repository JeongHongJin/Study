package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1261 {
	static class Node implements Comparable<Node>{
		int x, y, wall;

		Node(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			return;
		}
		public int compareTo(Node o) {
			return wall - o.wall;
		}
	}

	static int n, m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		move(0, 0);
		System.out.println(cnt);
	}

	static int cnt = 0;

	static void move(int x, int y) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(x, y, 0));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				cnt = now.wall;
				if (nx == m - 1 && ny == n - 1) {
					return;
				}
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (map[nx][ny] == '0' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, cnt));
					}
					if (map[nx][ny] == '1' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, cnt + 1));
					}
				}
			}
		}
	}
}
