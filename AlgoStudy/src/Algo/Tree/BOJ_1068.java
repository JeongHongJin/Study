package Algo.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1068 {
	static int n;
	static boolean[] visit;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		list = new ArrayList[n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		int root = -1;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(str[i]);
			if (now == -1) {
				root = i;
				continue;
			}
			list[now].add(i);
		}
		int r = Integer.parseInt(br.readLine());
		remove(r);
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		int cnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (list[now].size() == 0) {
				cnt++;
				continue;
			}
			for (int next : list[now]) {
				q.offer(next);
			}
		}
		if (root == r) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
		}
	}

	static void remove(int idx) {
		if (list[idx].size() > 0) {
			int size = list[idx].size();
			while (size > 0) {
				int child = list[idx].get(--size);
				remove(child);
			}
		}
		for (int i = 0; i < n; i++) {
			if (list[i].contains(idx)) {
				for (int j = 0; j < list[i].size(); j++) {
					if (list[i].get(j) == idx) {
						list[i].remove(j);
					}
				}
			}
		}
	}
}
