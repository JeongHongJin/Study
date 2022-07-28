package Algo.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			int n = Integer.parseInt(br.readLine());
			boolean[] r1 = new boolean[n];
			boolean[] r2 = new boolean[n];
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				int r = Integer.parseInt(str[2]);
				if (dis(x1, y1, x, y, r))
					r1[i] = true;
				if (dis(x2, y2, x, y, r))
					r2[i] = true;
			}
			int answer = 0;
			for (int i = 0; i < n; i++) {
				if (r1[i] != r2[i])
					answer++;
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static boolean dis(int x1, int y1, int x2, int y2, int r) {
		int a = Math.abs(x1 - x2);
		int b = Math.abs(y1 - y2);
		if (a * a + b * b <= r * r)
			return true;
		else
			return false;
	}
}
