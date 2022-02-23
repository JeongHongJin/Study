package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static int n, m, h;
	static int[] dx = { 0, 0, 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, -1, 1, 0, 0, 0, 0 };
	static int[][][] map;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][n][m];
		visit = new boolean[h][n][m];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		Ripen(0, 0, 0);
	}

	static void Ripen(int H, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 1) {
						q.offer(new int[] { i, j, k, 0 });
						visit[i][j][k] = true;
					}
				}
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int j = 0; j < 7; j++) {
				int nh = location[0] + dh[j];
				int nx = location[1] + dx[j];
				int ny = location[2] + dy[j];
				cnt = location[3];
				if (nh >= 0 && nx >= 0 && ny >= 0 && nh < h && nx < n && ny < m) {
					if (map[nh][nx][ny] == 0 && !visit[nh][nx][ny]) {
						map[nh][nx][ny] = 1;
						visit[nh][nx][ny] = true;
						q.offer(new int[] { nh, nx, ny, cnt + 1 });
					}
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
