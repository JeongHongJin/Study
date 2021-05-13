package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고 : 뱀귤 블로그
public class n14500 {
	static int N, M;
	static int max = -1;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				Block(i, j, 0, 0);
				visit[i][j] = false;
				Block2(i, j);
			}
		}
		System.out.println(max);

	}

	// DFS로 찾으면 ㅗ를 제외한 모든 모양을 탐색할 수 있다.
	static void Block(int x, int y, int depth, int score) {
		if (depth == 4) {
			max = Math.max(max, score);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					Block(nx, ny, depth + 1, score + map[nx][ny]);
					visit[nx][ny] = false;
				}
			}
		}
	}

	static void Block2(int x, int y) {
		// 1.꼭지점은 ㅗ 모양 안됨
		if ((x == 0 || x == N - 1) && (y == 0 || y == M - 1)) {
			return;
		}
		int score = map[x][y];
		// ㅏ
		if (x == 0) {
			score += map[x][y - 1] + map[x][y + 1] + map[x + 1][y];
		}
		// ㅓ
		else if (x == N - 1)
			score += map[x][y - 1] + map[x][y + 1] + map[x - 1][y];
		// ㅜ
		else if (y == 0)
			score += map[x - 1][y] + map[x + 1][y] + map[x][y + 1];
		// ㅗ
		else if (y == M - 1)
			score += map[x - 1][y] + map[x + 1][y] + map[x][y - 1];
		else {
			score = Math.max(score, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
			score = Math.max(score, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
			score = Math.max(score, map[x][y] + map[x][y + 1] + map[x - 1][y] + map[x + 1][y]);
			score = Math.max(score, map[x][y] + map[x][y - 1] + map[x - 1][y] + map[x + 1][y]);
		}
		max = Math.max(max, score);
	}
}
