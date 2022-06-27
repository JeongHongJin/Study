package Algo.Rotate;

public class PGR_77485 {
	class Solution {
		public int[] solution(int rows, int columns, int[][] queries) {
			int[] answer = new int[queries.length];
			int[][] map = new int[rows][columns];
			int num = 1;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					map[i][j] = num;
					num++;
				}
			}

			for (int i = 0; i < queries.length; i++) {
				int rs = queries[i][0] - 1;
				int cs = queries[i][1] - 1;
				int re = queries[i][2] - 1;
				int ce = queries[i][3] - 1;
				int min = Integer.MAX_VALUE;
				int tmp = map[rs][cs];
				for (int j = rs; j < re; j++) {
					map[j][cs] = map[j + 1][cs];
					min = Math.min(map[j + 1][cs], min);
				}
				for (int j = cs; j < ce; j++) {
					map[re][j] = map[re][j + 1];
					min = Math.min(map[re][j + 1], min);
				}
				for (int j = re; j > rs; j--) {
					map[j][ce] = map[j - 1][ce];
					min = Math.min(map[j - 1][ce], min);
				}
				for (int j = ce; j > cs; j--) {
					map[rs][j] = map[rs][j - 1];
					min = Math.min(map[rs][j - 1], min);
				}

				map[rs][cs + 1] = tmp;
				min = Math.min(tmp, min);
				answer[i] = min;
			}
			return answer;
		}
	}
}
