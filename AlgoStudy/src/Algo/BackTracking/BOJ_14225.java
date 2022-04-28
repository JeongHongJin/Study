package Algo.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14225 {
	static int[] arr;
	static boolean[] visit;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		arr = new int[n];
		visit = new boolean[2000001];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		makeList(0, 0);
		int answer = 1;
		while (true) {
			if (visit[answer])
				answer++;
			else
				break;
		}
		System.out.println(answer);
	}

	static void makeList(int depth, int sum) {
		if (depth == n) {
			visit[sum] = true;
			return;
		}

		makeList(depth + 1, sum + arr[depth]);
		makeList(depth + 1, sum);
	}
}
