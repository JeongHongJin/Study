package Algo.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6603 {
	static String[] arr;
	static String[] out;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			arr = br.readLine().split(" ");
			n = Integer.parseInt(arr[0]);
			out = new String[6];
			if (n == 0)
				break;
			comb(1, 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void comb(int start, int depth) {
		if (depth == 6) {
			for (String s : out)
				sb.append(s).append(' ');
			sb.append('\n');
			return;
		}
		for (int i = start; i <= n; i++) {
			out[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}
}
