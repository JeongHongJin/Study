package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2630 {
	static int n;
	static int[][] map;
	static int white = 0, blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, n);
		System.out.println(white);
		System.out.println(blue);

	}

	static void partition(int x, int y, int size) {
		if (check(x, y, size)) {
			if (map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		} else {
			int nSize = size / 2;
			// 분할 재귀
			// 1,2,3,4, 분면
			partition(x, y + nSize, nSize);
			partition(x, y, nSize);
			partition(x + nSize, y, nSize);
			partition(x + nSize, y + nSize, nSize);
		}
	}

	static boolean check(int x, int y, int size) {
		int color = map[x][y];
		for (int i = x; i < size + x; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
