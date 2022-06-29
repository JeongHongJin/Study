package Algo.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_86971 {
	class Solution {
		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			ArrayList<Integer>[] map = new ArrayList[n + 1];
			boolean[] visit = new boolean[n + 1];

			int cnt = 0;
			for (int i = 0; i < wires.length; i++) {
				for (int j = 0; j <= n; j++) {
					map[j] = new ArrayList<>();
				}
				for (int j = 0; j < wires.length; j++) {
					if (i == j)
						continue;
					int x = wires[j][0];
					int y = wires[j][1];
					map[x].add(y);
					map[y].add(x);
				}
				Queue<Integer> q = new LinkedList<>();
				visit = new boolean[n + 1];
				q.offer(1);
				cnt = 1;
				while (!q.isEmpty()) {
					int now = q.poll();
					if (visit[now])
						continue;
					visit[now] = true;
					for (int next : map[now]) {
						if (visit[next])
							continue;
						q.offer(next);
						cnt++;
					}
				}
				cnt = Math.abs(Math.abs(n - cnt) - cnt);
				answer = Math.min(answer, cnt);
			}

			return answer;
		}
	}
}
