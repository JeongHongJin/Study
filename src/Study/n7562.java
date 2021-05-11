package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n7562 {
	static int m, end1, end2;
	static int[][] map;
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			m = Integer.parseInt(br.readLine());
			map = new int[m][m];
			st = new StringTokenizer(br.readLine());
			int start1 = Integer.parseInt(st.nextToken());
			int start2 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			end1 = Integer.parseInt(st.nextToken());
			end2 = Integer.parseInt(st.nextToken());
			move(start1, start2);
		}
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();

	static void move(int x, int y) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y, 0 });
		map[x][y] = 1;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				cnt = location[2];
				if (nx >= 0 && ny >= 0 && nx < m && ny < m) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.offer(new int[] { nx, ny, cnt + 1 });
					}
				}
			}
			if (location[0] == end1 && location[1] == end2) {
				sb.append(cnt).append('\n');
				return;
			}
		}
	}
}
