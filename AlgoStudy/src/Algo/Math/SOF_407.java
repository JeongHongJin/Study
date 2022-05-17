package Algo.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOF_407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 1000000007;
		String[] str = br.readLine().split(" ");
		long k = Integer.parseInt(str[0]);
		long p = Integer.parseInt(str[1]);
		int n = Integer.parseInt(str[2]);
		for (int i = 0; i < n; i++) {
			k = (k * p) % mod;
			k %= mod;
		}
		System.out.println(k);
	}
}
