package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long answer = 1;
		while (answer <= n) {
			n -= answer;
			if (n - answer <= 0)
				break;
			answer++;
		}
		System.out.println(answer);
	}
}
