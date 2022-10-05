package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int set = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			set = Math.min(set, a);
			one = Math.min(one, b);
		}
		long sum = 0;
		int surplus = n % 6;
		n /= 6;
		if (set >= surplus * one) {
			sum += surplus * one;
		} else {
			if (surplus > 0) {
				sum += set;
			}
		}
		if (set >= 6 * one) {
			sum += one * n * 6;
		} else {
			if (n > 0) {
				sum += set * n;
			}
		}
		System.out.println(sum);
	}
}
