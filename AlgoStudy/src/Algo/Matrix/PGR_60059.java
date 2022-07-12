package Algo.Matrix;

public class PGR_60059 {
	class Solution {
		int r = 0;
		int c = 0;
		int lockCnt = 0;

		public boolean solution(int[][] key, int[][] lock) {
			boolean answer = true;
			r = key.length;
			c = key[0].length;
			int[][] key1 = rotate(key).clone();
			int[][] key2 = rotate(key1).clone();
			int[][] key3 = rotate(key2).clone();
			for (int i = 0; i < lock.length; i++) {
				for (int j = 0; j < lock[0].length; j++) {
					if (lock[i][j] == 0)
						lockCnt++;
				}
			}
			int l = lock.length - 1;
			if (check(lock, key, l, l))
				return true;
			if (check(lock, key1, l, l))
				return true;
			if (check(lock, key2, l, l))
				return true;
			if (check(lock, key3, l, l))
				return true;
			return false;
		}

		public boolean check(int[][] lock, int[][] key, int x, int y) {
			int[][] newLock = new int[60][60];
			for (int i = 0; i < lock.length; i++) {
				for (int j = 0; j < lock[0].length; j++) {
					newLock[i + x][j + y] = lock[i][j] + 1;
				}
			}
			for (int a = 0; a < 40; a++) {
				for (int b = 0; b < 40; b++) {
					int cnt = 0;
					loop: for (int i = 0; i < r; i++) {
						for (int j = 0; j < c; j++) {
							if (key[i][j] == 1 && newLock[i + a][j + b] == 2) {
								break loop;
							}
							if (key[i][j] == 1 && newLock[i + a][j + b] == 1) {
								cnt++;
							}
						}
					}
					if (lockCnt == cnt)
						return true;
				}
			}
			return false;
		}

		public int[][] rotate(int[][] key) {
			int[][] tmp = new int[r][c];
			for (int i = 0, y = 0; i < r; i++, y++) {
				for (int j = 0, x = r - 1; j < c; j++, x--) {
					tmp[i][j] = key[x][y];
				}
			}
			return tmp;
		}
	}
}
