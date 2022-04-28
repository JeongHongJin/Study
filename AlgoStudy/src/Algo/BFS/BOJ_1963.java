package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
	static boolean[] prime = new boolean[10001];
	static boolean[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1000; i < 10000; i++) {
			boolean flag = false;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				prime[i] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());

			int[] count = new int[10000];
			num = new boolean[10001];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			num[start] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 10; k++) {
						if (j == 0 && k == 0)
							continue;
						int tmp = change(now, j, k);
						if (prime[tmp] && !num[tmp]) {
							q.offer(tmp);
							num[tmp] = true;
							count[tmp] = count[now] + 1;
						}
					}
				}
			}
			if (start != goal && count[goal] == 0)
				sb.append("Impossible").append('\n');
			else
				sb.append(count[goal]).append('\n');
		}
		System.out.println(sb);
	}

	static int change(int now, int x, int y) {
		String s = Integer.toString(now);
		char[] tmp = s.toCharArray();
		tmp[x] = (char) (y + '0');
		String res = "";
		for (char c : tmp) {
			res += c;
		}
		return Integer.parseInt(res);
	}
}
