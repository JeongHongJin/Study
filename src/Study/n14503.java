package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 블로그참고
public class n14503 {
	static int N, M;
	static int cnt = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Cleaning(r, c, d);
		Check(map);

		System.out.println(cnt);
	}

	static void Cleaning(int x, int y, int d) {
		Queue<int[]> q = new LinkedList<>();
		map[x][y] = -1;
		q.offer(new int[] { x, y, d });
		while (!q.isEmpty()) {
			int[] location = q.poll();
			// 현재 위치, 방향
			int cx = location[0];
			int cy = location[1];
			int cd = location[2];
			boolean flag = false; // 4방향이 다 청소되어 있거나 벽일 경우
			// 다음 위치, 방향
			int nx;
			int ny;
			int nd;

			for (int i = 0; i < 4; i++) {
				// dx dy와 북 동 남 서 위치 맞추기
				cd = (cd + 3) % 4;
				nx = cx + dx[cd];
				ny = cy + dy[cd];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					// 청소 되지 않은 곳 청소한다.
					if (map[nx][ny] == 0) {
						q.offer(new int[] { nx, ny, cd });
						map[nx][ny] = -1;
						flag = true;
						break;
					}
				}
			}
			// 4방향 다 청소되었거나 벽일 경우에는 후진
			if (!flag) {
				nd = (cd + 2) % 4;
				nx = cx + dx[nd];
				ny = cy + dy[nd];
				// 후진할 곳이 벽이 아니라면, 이동 아니면 종료
				if (map[nx][ny] != 1) {
					map[nx][ny] = -1;
					q.offer(new int[] { nx, ny, cd });
				}
			}

		}
	}

	// 청소한 곳 체크
	static void Check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1)
					cnt++;
			}
		}
	}
}
