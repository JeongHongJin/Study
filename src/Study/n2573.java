package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2573 {
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int icnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while (icnt < 2) {
			icnt = 0;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						Search(i, j);
						icnt++;
					}
				}
			}
			if (icnt >= 2) {
				break;
			}
			if (icnt == 0) {
				System.out.println(0);
				return;
			}
			loop1: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						melt(i, j);
						break loop1;
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}

	static void Search(int x, int y) {
		visited[x][y] = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] != 0 && !visited[nx][ny]) {
						q.offer(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

	static void melt(int x, int y) {
		int[][] del = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		visit[x][y] = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node now = q.poll();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0) {
						cnt++;
					} else if (!visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny));
					}
				}
			}
			del[now.x][now.y] = cnt;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] -= del[i][j];
				if (map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}
	}
}
