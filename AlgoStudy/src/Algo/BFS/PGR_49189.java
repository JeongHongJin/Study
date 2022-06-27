package Algo.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_49189 {
	class Solution {
		ArrayList<Integer>[] map;
		int max = -1;

		public int solution(int n, int[][] edge) {
			map = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++)
				map[i] = new ArrayList<>();
			for (int i = 0; i < edge.length; i++) {
				int x = edge[i][0];
				int y = edge[i][1];
				map[x].add(y);
				map[y].add(x);
			}
			bfs(1, n);
			return max;
		}

		void bfs(int x, int n) {
			boolean[] visit = new boolean[n + 1];
			Queue<Integer> q = new LinkedList<>();
			q.offer(x);
			visit[x] = true;
			int cnt = 0;
			Queue<Integer> tmp = new LinkedList<>();
			while (true) {
				while (!q.isEmpty()) {
					int now = q.poll();
					for (int next : map[now]) {
						if (!visit[next]) {
							tmp.offer(next);
							visit[next] = true;
						}
					}
				}
				if (tmp.isEmpty())
					break;
				q.addAll(tmp); // 한 번에 자식 노드들 추가하기 기법
				cnt = tmp.size();
				tmp.clear();
			}
			max = cnt;
		}
	}
}
