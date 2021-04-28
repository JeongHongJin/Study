package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2606 {
	static int[][] map;
	static boolean[] visit;
	static int N, M;
	static int cnt = 0;

	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		bfs(1);
		System.out.println(cnt);
//		for (int i = 0; i < N+1; i++)
//			System.out.println(Arrays.toString(map[i]));
	}

	static void bfs(int point) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(point);
		visit[point] = true;
		while (!q.isEmpty()) {
			int x = q.poll();
//			System.out.println(x);
			if (x != 1)
				cnt++;
			for (int i = 1; i < N+1; i++) {
				// 다음 정점과 연결되어 있고 아직 방문하지 않았다면 추가
				if (map[x][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}