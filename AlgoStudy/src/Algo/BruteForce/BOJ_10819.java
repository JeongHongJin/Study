package Algo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10819 {
	static int n;
	static boolean[] visit;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		String[] out = new String[n];
		visit = new boolean[n];
		perm(0, out, str);
		System.out.println(max);
	}

	static void perm(int depth, String[] out, String[] str) {
		if (depth == n) {
			int tmp = 0;
			for (int i = 0; i < n - 1; i++) {
				tmp += Math.abs(Integer.parseInt(out[i]) - Integer.parseInt(out[i + 1]));
			}
			max = Math.max(tmp, max);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			out[depth] = str[i];
			perm(depth + 1, out, str);
			visit[i] = false;
		}
	}
}
