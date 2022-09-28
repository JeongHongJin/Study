package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		parent = new int[g + 1];

		for (int i = 0; i <= g; i++) {
			parent[i] = i;
		}
		int cnt = 0;

		for (int i = 0; i < p; i++) {
			int tmp = Integer.parseInt(br.readLine());
			int now = find(tmp);
			if (now != 0) {
				union(now, now - 1);
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
	}

	static int find(int n) {
		if (n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[a] = b;
		}
	}
}
