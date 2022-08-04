package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BOJ_1766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer>[] map = new ArrayList[n + 1];
		int[] degree = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x].add(y);
			degree[y]++;
		}
		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0)
				pq.offer(i);
		}
		boolean[] visit = new boolean[n + 1];
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int now = pq.poll();
			if (visit[now])
				continue;
			visit[now] = true;
			sb.append(now).append(' ');
			for (int next : map[now]) {
				if (visit[next])
					continue;
				degree[next]--;
				if (degree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		System.out.println(sb);
	}
}
