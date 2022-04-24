package Algo.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	static int n, s;
	static int cnt = 0;
	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			combi(0, n, i);
		}
		System.out.println(cnt);
	}

	static void combi(int start, int depth, int goal) {
		if (goal == 0) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					sum += arr[i];
				}
			}
			if (sum == s) {
				cnt++;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			visit[i] = true;
			combi(i + 1, depth + 1, goal - 1);
			visit[i] = false;
		}
	}
}
