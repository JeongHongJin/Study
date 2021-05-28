package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1780 {
	static int n, cnt = 0, cnt2 = 0, cnt3 = 0;
	static int[][] map;

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
		System.out.println(cnt);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}

	static void partition(int x, int y, int size) {
		if (check(x, y, size)) {
			if (map[x][y] == -1) {
				cnt++;
			} else if (map[x][y] == 0) {
				cnt2++;
			} else {
				cnt3++;
			}
		} else {
			int nSize = size / 3;
			partition(x, y, nSize);
			partition(x + nSize, y, nSize);
			partition(x + nSize + nSize, y, nSize);
			partition(x, y + nSize, nSize);
			partition(x + nSize, y + nSize, nSize);
			partition(x + nSize + nSize, y + nSize, nSize);
			partition(x, y + nSize + nSize, nSize);
			partition(x + nSize, y + nSize + nSize, nSize);
			partition(x + nSize + nSize, y + nSize + nSize, nSize);
		}
	}

	static boolean check(int x, int y, int size) {
		int num = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != num) {
					return false;
				}
			}
		}
		return true;
	}
}
