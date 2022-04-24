package Algo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2529 {
	static String[] str;
	static int[] out;
	static boolean[] visit;
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		out = new int[n + 1];
		str = br.readLine().split(" ");
		visit = new boolean[10];
		int[] num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i] = i;
		}
		comb(0, n, num);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	static void comb(int depth, int n, int[] c) {
		if (depth == n + 1) {
			if (check()) {
				String tmp = "";
				for (int i : out)
					tmp += i;
				list.add(tmp);
			}
			return;
		}
		for (int i = 0; i < c.length; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			out[depth] = c[i];
			comb(depth + 1, n, c);
			visit[i] = false;
		}
	}

	static boolean check() {
		for (int i = 0; i < str.length; i++) {
			if (str[i].charAt(0) == '>') {
				if (out[i] <= out[i + 1])
					return false;

			} else {
				if (out[i] >= out[i + 1])
					return false;
			}
		}
		return true;
	}
}
