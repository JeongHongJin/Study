package Algo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int answer = 0;
		int start = 0;
		int end = 0;
		int len = arr.length;
		int sum = 0;
		while (true) {
			if (sum >= m) {
				sum -= arr[start++];
			} else if (end >= len) {
				break;
			} else {
				sum += arr[end++];
			}
			if (sum == m) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
