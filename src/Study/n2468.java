package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2468 {
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = -1;
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				map[i][j] = num;
			}
		}
		int answer = -1;
		for (int i = 1; i <= max; i++) {
			visit = new boolean[n][n];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] >= i && !visit[j][k]) {
						Search(j, k, i);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	static void Search(int x, int y, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] >= h && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}
}
