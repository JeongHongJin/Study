package Algo.Matrix;

public class PGR_120875 {
	class Solution {
		public int solution(int[][] dots) {
			int answer = 0;
			for (int i = 0; i < dots.length; i++) {
				int[] a = dots[i];
				for (int j = i + 1; j < dots.length; j++) {
					int[] b = dots[j];
					boolean[] visit = new boolean[4];
					visit[i] = true;
					visit[j] = true;
					for (int k = 0; k < 4; k++) {
						if (!visit[k]) {
							int[] c = dots[k];
							for (int x = 0; x < 4; x++) {
								if (!visit[x]) {
									int[] d = dots[x];
									double x1 = a[0] - b[0];
									double y1 = a[1] - b[1];
									double x2 = c[0] - d[0];
									double y2 = c[1] - d[1];
									if (x1 / y1 == x2 / y2) {
										return 1;
									}
								}
							}
						}
					}
				}
			}
			return answer;
		}
	}
}
