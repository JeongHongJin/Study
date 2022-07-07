package Algo.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_43162 {
	class Solution {

		public int solution(int n, int[][] computers) {
			int answer = 0;
			ArrayList<Integer>[] map = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++)
				map[i] = new ArrayList<>();

			for (int i = 0; i < computers.length; i++) {
				for (int j = 0; j < computers[0].length; j++) {
					if (computers[i][j] == 0)
						continue;
					if (i == j)
						continue;
					map[i].add(j);
					map[j].add(i);
				}
			}
			Queue<Integer> q = new LinkedList<>();
			boolean[] visit = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (visit[i])
					continue;
				q.offer(i);
				while (!q.isEmpty()) {
					int now = q.poll();
					if (visit[now])
						continue;
					visit[now] = true;
					for (int next : map[now]) {
						q.offer(next);
					}
				}
				answer++;
			}
			return answer;
		}
	}
}
