package Algo.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int[] out;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		boolean[] visit = new boolean[n];
		out = new int[r];
		backTracking(n, r, 0, arr, visit);
		System.out.println(sb);
	}

	static void backTracking(int n, int r, int depth, int[] arr, boolean[] visit) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(out[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			out[depth] = i + 1;
			backTracking(n, r, depth + 1, arr, visit);
			visit[i] = false;
		}
	}
}
