package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//출처: https://coder-in-war.tistory.com/entry/BOJ-JAVA3687-%EC%84%B1%EB%83%A5%EA%B0%9C%EB%B9%84
public class BOJ_3687 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] min = new long[101];
			Arrays.fill(min, Long.MAX_VALUE);
			min[2] = 1;
			min[3] = 7;
			min[4] = 4;
			min[5] = 2;
			min[6] = 6;
			min[7] = 8;
			min[8] = 10;

			int[] add = { 1, 7, 4, 2, 0, 8 };

			for (int i = 9; i < 101; i++) {
				for (int j = 2; j < 8; j++) {
					String now = "" + min[i - j] + add[j - 2];
					min[i] = Math.min(Long.parseLong(now), min[i]);
				}
			}
			StringBuilder max = new StringBuilder();
			long a = n / 2;
			long b = n % 2;
			if (b == 1) {
				max.append(7);
			} else {
				max.append(1);
			}
			for (int i = 1; i < a; i++) {
				max.append(1);
			}
			sb.append(min[n]).append(" ").append(max.toString()).append('\n');
		}
		System.out.println(sb);
	}
}
