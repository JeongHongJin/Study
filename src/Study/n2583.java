package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2583 {
	static int m, n;
	// map = 그래프 영역표시
	static int[][] map;
	// visit = 방문 확인
	static boolean[][] visit;
	// dx,dy = 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공백 포함된 문자열 입력 받기 위해
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 영역 갯수 확인 위해 list 선언
		ArrayList<Integer> list = new ArrayList<>();
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		// map과 visit을 m,n행렬로 초기화
		map = new int[m][n];
		visit = new boolean[m][n];
		int K = Integer.parseInt(st.nextToken());
		// K개의 명령 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 좌표와 오른쪽 위 좌표 입력
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 영역 색칠하기 (중복된 경우 따로 체크 안해도 되므로 1로 초기화)
			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					map[k][j] = 1;
				}
			}
		}
		// 영역 확인
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					list.add(Search(i, j));
				}
			}
		}
		// 영역 넓이 오름 차순으로 정렬
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}
	}

	// BFS활용
	static int Search(int x, int y) {
		// 첫 칸 영역 넓이 1로 초기화
		int cnt = 1;
		// q에 x,y좌표 추가
		Queue<int[]> q = new LinkedList<>();
		// 방문 체크
		visit[x][y] = true;
		// q에 좌표 입력
		q.offer(new int[] { x, y });
		// 더 이상 추가된 좌표가 없으면 while문 종료
		while (!q.isEmpty()) {
			// 추가된 x,y의 좌표
			int[] location = q.poll();
			// 상하좌우 전부 확인 하기
			for (int i = 0; i < 4; i++) {
				// 현재 위치에서 상하좌우로 움직인 좌표값
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				// 영역의 범위 초과 시 무시
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					// 영역이 0인경우 색칠된적 없는경우
					// 한번도 방문하지 않은 영역
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						// 영역 넓이 더하고
						// 방문으로 변경
						// q에 새로운 좌표 추가
						cnt++;
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		return cnt;
	}
}
