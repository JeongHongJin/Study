package Algo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class PGR_81302 {
	class Solution {
		public int[] solution(String[][] places) {
			int[] answer = new int[5];
			for (int i = 0; i < 5; i++) {
				boolean flag = true;
				char[][] map = new char[5][5];
				for (int j = 0; j < 5; j++) {
					String s = places[i][j];
					for (int k = 0; k < 5; k++) {
						map[j][k] = s.charAt(k);
					}
				}
				loop: for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						if (map[j][k] == 'P') {
							if (!bfs(j, k, map)) {
								flag = false;
								break loop;
							}
						}
					}
				}
				if (flag) {
					answer[i] = 1;
				}
			}

			return answer;
		}

		public boolean bfs(int x, int y, char[][] map) {
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(x, y, 0));
			boolean[][] visit = new boolean[5][5];
			visit[x][y] = true;
			while (!q.isEmpty()) {
				Node now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
						continue;
					if (visit[nx][ny])
						continue;
					if (map[nx][ny] == 'O') {
						q.offer(new Node(nx, ny, now.dis + 1));
						visit[nx][ny] = true;
					}
					if (map[nx][ny] == 'P' && now.dis < 2) {
						return false;
					}
				}
			}
			return true;
		}
	}

	class Node {
		int x;
		int y;
		int dis;

		Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}
