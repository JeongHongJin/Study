package Algo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 0;
		int sum = 1;
		int num = 10;
		for (int i = 1; i <= n; i++) {
			if (i % num == 0) {
				sum++;
				num *= 10;
			}
			answer += sum;
		}
		System.out.println(answer);
	}
}
