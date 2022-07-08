package Algo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class PGR_87694 {
	class Solution {
		class Node {
			int x;
			int y;
			int val;

			Node(int x, int y, int val) {
				this.x = x;
				this.y = y;
				this.val = val;
			}
		}

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int answer = 0;

		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
			answer = 0;
			int[][] map = new int[102][102];
			for (int i = 0; i < rectangle.length; i++) {
				int x1 = rectangle[i][0] * 2;
				int y1 = rectangle[i][1] * 2;
				int x2 = rectangle[i][2] * 2;
				int y2 = rectangle[i][3] * 2;
				for (int j = x1; j <= x2; j++) {
					for (int k = y1; k <= y2; k++) {
						map[j][k] = 1;
					}
				}
			}
			for (int i = 0; i < rectangle.length; i++) {
				int x1 = rectangle[i][0] * 2;
				int y1 = rectangle[i][1] * 2;
				int x2 = rectangle[i][2] * 2;
				int y2 = rectangle[i][3] * 2;
				for (int j = x1 + 1; j < x2; j++) {
					for (int k = y1 + 1; k < y2; k++) {
						map[j][k] = 0;
					}
				}
			}
			bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);

			return answer;
		}

		public void bfs(int[][] map, int cx, int cy, int ix, int iy) {
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(cx, cy, 1));
			boolean[][] visit = new boolean[102][102];
			visit[cx][cy] = true;
			while (!q.isEmpty()) {
				Node now = q.poll();
				if (now.x == ix && now.y == iy) {
					answer = now.val / 2;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102)
						continue;
					if (visit[nx][ny])
						continue;
					if (map[nx][ny] == 1) {
						visit[nx][ny] = true;
						q.offer(new Node(nx, ny, now.val + 1));
					}
				}
			}
		}
	}
}
