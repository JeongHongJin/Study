package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class n10026 {
	static int n;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int cnt = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'R' && !visit[i][j]) {
					SearchR(i, j);
					cnt++;
				} else if (map[i][j] == 'G' && !visit[i][j]) {
					SearchG(i, j);
					cnt++;
				} else if (map[i][j] == 'B' && !visit[i][j]) {
					SearchB(i, j);
					cnt++;
				}
			}
		}
		int cnt2 = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((map[i][j] == 'R' || map[i][j] == 'G') && !visit[i][j]) {
					SearchRG(i, j);
					cnt2++;
				} else if (map[i][j] == 'B' && !visit[i][j]) {
					SearchB(i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt + " " + cnt2);
	}

	static void SearchR(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'R' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void SearchG(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'G' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void SearchB(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'B' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void SearchRG(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if ((map[nx][ny] == 'R' || map[nx][ny] == 'G') && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}
}
