package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		if (n == 1 || n == 3) {
			System.out.println(-1);
			return;
		}
		answer += (n / 5);
		n %= 5;
		answer += (n / 2);
		n %= 2;
		if (n == 1)
			answer += 2;
		System.out.println(answer);
	}
}
