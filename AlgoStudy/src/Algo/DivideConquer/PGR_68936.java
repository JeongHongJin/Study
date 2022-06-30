package Algo.DivideConquer;

import java.util.HashMap;

public class PGR_68936 {
	class Solution {
		boolean[][] visit;
		HashMap<Integer, Integer> map = new HashMap<>();

		public int[] solution(int[][] arr) {
			int[] answer = new int[2];
			int n = arr.length;
			visit = new boolean[n][n];
			map.put(0, 0);
			map.put(1, 0);
			divide(0, 0, n, arr);
			answer[0] = map.get(0);
			answer[1] = map.get(1);
			return answer;
		}

		void divide(int x, int y, int size, int[][] arr) {
			int now = arr[x][y];
			if (visit[x][y])
				return;
			boolean flag = false;
			loop: for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (arr[i][j] != now) {
						flag = true;
						break loop;
					}
				}
			}
			if (!flag) {
				for (int i = x; i < x + size; i++) {
					for (int j = y; j < y + size; j++) {
						visit[i][j] = true;
					}
				}
				map.put(now, map.get(now) + 1);
			}

			divide(x, y, size / 2, arr);
			divide(x, y + size / 2, size / 2, arr);
			divide(x + size / 2, y, size / 2, arr);
			divide(x + size / 2, y + size / 2, size / 2, arr);
		}
	}

}
