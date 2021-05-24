package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출처 및 참고 : devje8블로그
// 참고 할때 dx,dy의 정보를 바꾸면 오답이 나온다 추가 체크가 필요하다.
public class n16236 {
	static int n, x, y;
	// 아기 상어 크기
	static int shark = 2;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visit;
	// 탐색 순서 중요
	// 같은 거리를 탐색할때 왼쪽 상단이 우선시 되어야한다
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					// 아기 상어 위치를 0으로 초기화
					map[i][j] = 0;
				}
			}
		}
		Eat(x, y);
	}

	static int time = 0;

	static void Eat(int x, int y) {
		// BFS 탐색 순서
		Queue<int[]> q = new LinkedList<>();
		// 남은 물고기의 정보
		ArrayList<int[]> fish = new ArrayList<>();
		// x,y좌표와 거리
		q.offer(new int[] { x, y, 0 });
		visit = new boolean[n][n];
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] location = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
					if (map[nx][ny] > 0 && map[nx][ny] < shark) {
						// 상어의 위치갱신
						q.offer(new int[] { nx, ny, location[2] + 1 });
						// 먹이 리스트 추가
						fish.add(new int[] { nx, ny, location[2] + 1 });
						visit[nx][ny] = true;
					}
					// 먹을 수는 없어도 지나갈 수 잇는거리
					else if (map[nx][ny] == shark || map[nx][ny] == 0) {
						q.offer(new int[] { nx, ny, location[2] + 1 });
						visit[nx][ny] = true;
					}
				}
			}
		}
		// 먹을 물고기가 없는 경우
		if (fish.size() == 0) {
			System.out.println(time);
			return;
		}
		// 먹을 물고기가 잇는 경우
		int[] eatfish = fish.get(0);
		for (int i = 1; i < fish.size(); i++) {
			if (fish.get(i)[2] < eatfish[2]) {
				// 거리가 최소인 물고기로 갱신
				eatfish = fish.get(i);
			}
			if (eatfish[2] == fish.get(i)[2]) {
				// 거리가 같은 경우 왼쪽 물고기 우선순위
				if (eatfish[0] > fish.get(i)[0]) {
					eatfish = fish.get(i);
				}
			}
		}
		time += eatfish[2];
		cnt++;
		// 먹은 자리 0으로 갱신
		map[eatfish[0]][eatfish[1]] = 0;
		if (cnt == shark) {
			// 아기상어 진화
			shark++;
			cnt = 0;
		}
		x = eatfish[0];
		y = eatfish[1];
		// 상어의 위치 갱신 후 다시 BFS
		Eat(x, y);
	}

}
