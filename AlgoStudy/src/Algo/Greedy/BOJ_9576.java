package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_9576 {
	static class Node implements Comparable<Node> {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Node n) {
			return this.y - n.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			ArrayList<Node> list = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				// b번호의 오름차순으로 정렬
				list.add(new Node(a, b));
			}
			Collections.sort(list);
			int cnt = 0;
			boolean[] visit = new boolean[n + 1];
			for (Node now : list) {
				int start = now.x;
				int end = now.y;
				// 처음점부터 끝점까지 방문 비교
				for (int i = start; i <= end; i++) {
					if (!visit[i]) {
						visit[i] = true;
						cnt++;
						break;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}
