package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n1012 {
	static int n, m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static int cnt;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			int answer = 0;
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					if (map[a][b] == 1 && !visit[a][b]) {
						cnt = 1;
						answer++;
						Search(a, b);
					}
				}
			}
			list.add(answer);
		}
		for (int i : list)
			System.out.println(i);
	}

	static int Search(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] == 1 && !visit[nx][ny]) {
					cnt++;
					Search(nx, ny);
				}
			}
		}
		return cnt;
	}
}
