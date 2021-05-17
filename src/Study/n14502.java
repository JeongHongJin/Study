package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고 : 츄르 사려고 코딩하는 집사
public class n14502 {
	static int m, n;
	static int answer = -1;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wall(0);
		System.out.println(answer);

	}

	// 최대 3개의 벽을 세우는 경우의수 전부 탐색
	static void wall(int depth) {
		if (depth == 3) {
			// 3개의 벽 세운 뒤에 감염 시키기
			infest();
			return;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall(depth + 1);
					// 벽 세우고 난 뒤 모든벽 다시 허물기
					map[i][j] = 0;
				}
			}
		}
	}

	static void infest() {
		Queue<int[]> q = new LinkedList<>();
		// 임시 감염된 map 만들기
		int[][] virus = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				virus[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (virus[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}
		// 벽 뚫린곳 전부 감염시키기
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (virus[nx][ny] == 0) {
						virus[nx][ny] = 2;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		// 안전 지역 찾기
		safe(virus);

	}

	static void safe(int[][] virus) {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (virus[i][j] == 0)
					cnt++;
			}
		}
		answer = Math.max(answer, cnt);
	}
}
