package Algo.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_67260 {
	class Solution {
		public boolean solution(int n, int[][] path, int[][] order) {
			boolean answer = true;
			ArrayList<Integer>[] map = new ArrayList[n];
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				map[i] = new ArrayList<>();
			}
			for (int i = 0; i < path.length; i++) {
				int x = path[i][0];
				int y = path[i][1];
				map[x].add(y);
				map[y].add(x);
			}
			int[] check = new int[n];
			for (int i = 0; i < order.length; i++) {
				check[order[i][1]] = order[i][0];
			}
			if (check[0] != 0)
				return false;
			boolean[] visit = new boolean[n];
			int[] idx = new int[n]; // 방문하기 위해 들려야할 노드 저장
			// root를 0으로 정한다.
			for (int i : map[0]) {
				q.offer(i);
			}
			visit[0] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				if (visit[now])
					continue;
				if (!visit[check[now]]) {
					idx[check[now]] = now;
					continue;
				}
				visit[now] = true;
				for (int next : map[now]) {
					q.offer(next);
				}
				q.offer(idx[now]);
			}
			System.out.println(Arrays.toString(visit));
			for (int i = 0; i < n; i++)
				if (!visit[i])
					return false;
			return answer;
		}
	}
}
