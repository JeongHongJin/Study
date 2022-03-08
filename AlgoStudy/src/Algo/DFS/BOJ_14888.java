package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int[] num;
	static int[] operation = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int n;

	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		dfs(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int number, int index) {
		if (index == n) {
			min = Math.min(min, number);
			max = Math.max(max, number);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operation[i] > 0) {
				operation[i]--;
				switch (i) {
				case 0:
					dfs(number + num[index], index + 1);
					break;
				case 1:
					dfs(number - num[index], index + 1);
					break;
				case 2:
					dfs(number * num[index], index + 1);
					break;
				case 3:
					dfs(number / num[index], index + 1);
					break;
				}
				operation[i]++;
			}
		}
	}
}
