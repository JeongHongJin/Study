package Algo.Implement;

public class PGR_60061 {
	class Solution {
		boolean[][] pillar;
		boolean[][] bar;
		int cnt = 0;

		public int[][] solution(int n, int[][] build_frame) {
			int[][] answer = {};
			pillar = new boolean[n + 1][n + 1];
			bar = new boolean[n + 1][n + 1];
			for (int i = 0; i < build_frame.length; i++) {
				int x = build_frame[i][0];
				int y = build_frame[i][1];
				int a = build_frame[i][2];
				int b = build_frame[i][3];
				build(n, x, y, a, b);
			}
			answer = new int[cnt][3];
			int idx = 0;
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if (pillar[i][j]) {
						answer[idx][0] = i;
						answer[idx][1] = j;
						answer[idx++][2] = 0;
					}
					if (bar[i][j]) {
						answer[idx][0] = i;
						answer[idx][1] = j;
						answer[idx++][2] = 1;
					}
				}
			}
			return answer;
		}

		public void build(int n, int x, int y, int a, int b) {
			if (a == 0) {
				if (b == 0) {
					pillar[x][y] = false;
					if (!Delete(n)) {
						pillar[x][y] = true;
					} else {
						cnt--;
					}
				} else if (b == 1) {
					if (check_pillar(x, y)) {
						pillar[x][y] = true;
						cnt++;
					}
				}
			} else if (a == 1) {
				if (b == 0) {
					bar[x][y] = false;
					if (!Delete(n)) {
						bar[x][y] = true;
					} else {
						cnt--;
					}
				} else if (b == 1) {
					if (check_bar(x, y)) {
						bar[x][y] = true;
						cnt++;
					}
				}
			}
		}

		public boolean Delete(int n) {
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					// 기둥, 보 설치 삭제 불가능한 경우
					if (pillar[i][j] && !check_pillar(i, j))
						return false;
					else if (bar[i][j] && !check_bar(i, j))
						return false;
				}
			}
			return true;
		}

		public boolean check_pillar(int x, int y) {
			if (y == 0) // 제일 바닥인경우
				return true;
			else if (y > 0 && pillar[x][y - 1]) // 바로 밑에 기둥 존재
				return true;
			else if (x > 0 && bar[x - 1][y] || bar[x][y])
				return true;
			return false;
		}

		public boolean check_bar(int x, int y) {
			// 한쪽 끝 기둥 연결
			if (y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1])
				return true;
			// 양쪽 보가 연결되어 있는 경우
			else if (x > 0 && bar[x - 1][y] && bar[x + 1][y])
				return true;
			return false;
		}
	}
}
