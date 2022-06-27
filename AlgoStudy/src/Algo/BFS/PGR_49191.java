package Algo.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_49191 {
	class Solution {
		int tmpcnt = 0;

		public int solution(int n, int[][] results) {
			int answer = 0;
			ArrayList<Integer>[] map = new ArrayList[n + 1];
			ArrayList<Integer>[] map2 = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				map[i] = new ArrayList<>();
				map2[i] = new ArrayList<>();
			}
			for (int i = 0; i < results.length; i++) {
				int x = results[i][0];
				int y = results[i][1];
				map[x].add(y);
				map2[y].add(x);
			}
			Queue<Integer> q = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];
			int[] cnt = new int[n + 1];
			int[] cnt2 = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				visit = new boolean[n + 1];
				q.offer(i);
				tmpcnt = 0;
				bfs(i, map, visit);
				cnt[i] = tmpcnt;
			}
			for (int i = 1; i <= n; i++) {
				visit = new boolean[n + 1];
				q.offer(i);
				tmpcnt = 0;
				bfs(i, map2, visit);
				cnt2[i] = tmpcnt;
			}
			for (int i = 1; i <= n; i++)
				if (cnt[i] + cnt2[i] == n - 1)
					answer++;
			return answer;
		}

		// Q에 넣는것과 재귀의 차이 좀 더 찾아보자
		void bfs(int x, ArrayList<Integer>[] map, boolean[] visit) {
			visit[x] = true;
			for (int next : map[x]) {
				if (!visit[next]) {
					tmpcnt++;
					bfs(next, map, visit);
				}
			}
		}
	}
}
