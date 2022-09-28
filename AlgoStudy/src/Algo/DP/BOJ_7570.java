package Algo.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7570 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] dp = new int[n + 1];
		int[] arr = new int[n];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		for (int i = 1; i <= n; i++) {
			int tmp = arr[i - 1];
			dp[tmp] = dp[tmp - 1] + 1;
		}
		Arrays.sort(dp);
		System.out.println(n - dp[n]);
	}
}
