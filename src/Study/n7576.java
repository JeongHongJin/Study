package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n7576 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		bfs(0, 0);
	}

	static void bfs(int x, int y) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
					visit[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				cnt = location[2];
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, cnt + 1 });
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);

	}
}
