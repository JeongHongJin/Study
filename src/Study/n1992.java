package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n1992 {
	static int n;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		partition(0, 0, n);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();

	static void partition(int x, int y, int size) {
		if (check(x, y, size)) {
			if (map[x][y] == '1') {
				sb.append(1);
			} else {
				sb.append(0);
			}
			return;
		} else {
			int nSize = size / 2;
			sb.append("(");
			partition(x, y, nSize);
			partition(x, y + nSize, nSize);
			partition(x + nSize, y, nSize);
			partition(x + nSize, y + nSize, nSize);
			sb.append(")");
		}

	}

	static boolean check(int x, int y, int size) {
		char color = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
