package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고 leeinae 블로그

public class n1697 {
	static int n, k;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visit = new int[100001];
		if(n==k) {
			System.out.println(0);
			return;
		}
		bfs(n);

	}

	static void bfs(int point) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(point);
		visit[point] = 1;
		while (!q.isEmpty()) {
			int location = q.poll();
			for (int i = 0; i < 3; i++) {
				int npoint;
				if (i == 0) {
					npoint = location + 1;
				} else if (i == 1) {
					npoint = location - 1;
				} else {
					npoint = location * 2;
				}
				if (npoint == k) {
					System.out.println(visit[location]);
					return;
				}
				if (npoint >= 0 && npoint < visit.length && visit[npoint] == 0) {
					q.offer(npoint);
					visit[npoint] = visit[location] + 1;
				}
			}

		}
	}

}
