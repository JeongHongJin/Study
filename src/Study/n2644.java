package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2644 {
	static int n;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		// 그래프 만들기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		System.out.println(cousin(r1, r2));
	}

	// 시작점부터 목표점까지
	static int cousin(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		// 시작점 추가
		q.offer(start);
		int cnt = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			// q의 크기만큼 목표점까지 반복
			for (int i = 0; i < len; i++) {
				int location = q.poll();
				// 목표점 도달시 return
				if (location == end) {
					return cnt;
				}
				// 그래프 연결 확인
				for (int j = 1; j <= n; j++) {
					if (map[location][j] == 1 && !visit[j]) {
						visit[j] = true;
						q.offer(j);
					}
				}
			}
			cnt++;
		}
		return -1;
	}
}
