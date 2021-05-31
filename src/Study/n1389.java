package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1389 {
	static ArrayList<Integer>[] list;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (j != i) {
					sum += Search(i, j, 0);
				}
			}
			if (sum < min) {
				answer = i;
				min = Math.min(min, sum);
			}
		}
		System.out.println(answer);
	}

	static int Search(int start, int find, int cnt) {
		boolean[] visit = new boolean[n + 1];
		int[] check = new int[n + 1];

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(start);
		while (!pq.isEmpty()) {
			int now = pq.poll();
			Iterator<Integer> it = list[now].iterator();
			while (it.hasNext()) {
				int next = it.next();
				if (!visit[next]) {
					check[next] = check[now] + 1;

					if (next == find) {
						return check[next];
					}
					visit[next] = true;
					pq.offer(next);
				}
			}
		}
		return 0;
	}
}