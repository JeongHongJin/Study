package Algo.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	static int[][] map;
	static int n;
	static int[] arr;
	static boolean[] visit;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(Min);
	}

	static void combination(int point, int depth) {
		if (depth == n / 2) {
			difference();
			return;
		}
		for (int i = point; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combination(i + 1, depth + 1);
				visit[i] = false;
			}
		}

	}

	static void difference() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (visit[i] == true && visit[j] == true) {
					start += map[i][j];
					start += map[j][i];
				} else if (visit[i] == false && visit[j] == false) {
					link += map[i][j];
					link += map[j][i];
				}
			}
		}
		int val = Math.abs(start - link);
		if (val == 0) {
			Min = 0;
			return;
		}
		Min = Math.min(val, Min);
	}
}
