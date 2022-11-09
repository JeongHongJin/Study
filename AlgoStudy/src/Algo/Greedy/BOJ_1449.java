package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int l = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int[] arr = new int[n];
		int answer = 1;
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		double left = arr[0] - 0.5;
		for (int i = 0; i < arr.length; i++) {
			if (left + l < arr[i]) {
				answer++;
				left = arr[i] - 0.5;
			}
		}
		System.out.println(answer);
	}
}
