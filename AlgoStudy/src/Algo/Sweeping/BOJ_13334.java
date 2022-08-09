package Algo.Sweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_13334 {
	static class Node implements Comparable<Node> {
		long x;
		long y;

		Node(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Node n) {
			return Long.compare(this.y, n.y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			long x = Long.parseLong(str[0]);
			long y = Long.parseLong(str[1]);
			list.add(new Node(Math.min(x, y), Math.max(x, y)));
		}
		long len = Long.parseLong(br.readLine());
		Collections.sort(list);
		int answer = 0;
		// 시작점을 pq로 정해야한다.
		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < list.size(); i++) {
			long nx = list.get(i).x;
			long ny = list.get(i).y;
			if (ny - nx > len)
				continue;
			pq.offer(nx);
			// pq가 존재하며 시작점이 끝점 - 최대길이가 되면 불가능이기때문에 poll한다.
			while (!pq.isEmpty()) {
				if (ny - pq.peek() <= len)
					break;
				pq.poll();
			}
			answer = Math.max(answer, pq.size());
		}
		System.out.println(answer);
	}
}
