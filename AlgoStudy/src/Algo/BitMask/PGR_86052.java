package Algo.BitMask;

import java.util.ArrayList;
import java.util.Arrays;

public class PGR_86052 {
	class Solution {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		boolean[][][] visit;
		int r = 0;
		int c = 0;

		public int[] solution(String[] grid) {
			int[] answer = {};
			ArrayList<Integer> list = new ArrayList<>();
			char[][] map = new char[grid.length][grid[0].length()];
			for (int i = 0; i < grid.length; i++) {
				map[i] = grid[i].toCharArray();
			}
			int max = 0;
			r = grid.length;
			c = grid[0].length();
			visit = new boolean[r][c][4];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					for (int k = 0; k < 4; k++) {
						if (!visit[i][j][k]) {
							list.add(check(grid, i, j, k));
						}
					}
				}
			}
			answer = new int[list.size()];
			for (int i = 0; i < answer.length; i++)
				answer[i] = list.get(i);
			Arrays.sort(answer);
			return answer;
		}

		int check(String[] grid, int x, int y, int d) {
			int cnt = 0;
			while (true) {
				if (visit[x][y][d])
					break;
				visit[x][y][d] = true;
				cnt++;
				if (grid[x].charAt(y) == 'R') {
					d = (d + 1) % 4;
				} else if (grid[x].charAt(y) == 'L') {
					d = (d + 3) % 4;
				}
				x = (x + dx[d] + r) % r;
				y = (y + dy[d] + c) % c;
			}
			return cnt;
		}
	}
}
