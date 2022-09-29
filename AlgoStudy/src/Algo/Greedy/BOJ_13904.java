package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_13904 {
	static class Node implements Comparable<Node> {
		int x;
		int val;

		Node(int x, int val) {
			this.x = x;
			this.val = val;
		}

		public int compareTo(Node n) {
			return this.x - n.x;
		}
//		public int compareTo(Node n) {
//			return n.val - this.val;
//		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		int[] visit = new int[1001];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			list.add(new Node(x, y));
		}
		Collections.sort(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// d-day 오름차순 정렬됨
		for (Node now : list) {
			// val를 추가
			pq.offer(now.val);
			// q 크기보다 들어가야할 날짜 크면
			if (pq.size() > now.x) {
				pq.poll();
			}
		}
		while (!pq.isEmpty()) {
			cnt += pq.poll();
		}
		// val값 내림차순 정렬됨
//		for (Node now : list) {
//			for (int i = now.x; i > 0; i--) {
//				if (visit[i] == 0) {
//					visit[i] = now.val;
//					break;
//				}
//			}
//		}
//		for (int num : visit) {
//			cnt += num;
//		}
		System.out.println(cnt);
	}
}
