package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n8979 {
	static class Node implements Comparable<Node> {
		int ctr, gold, silver, bronze, rank;

		Node(int ctr, int gold, int silver, int bronze, int rank) {
			this.ctr = ctr;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}

		public int compareTo(Node o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					return o.bronze - this.bronze;
				} else {
					return o.silver - this.silver;
				}
			} else {
				return o.gold - this.gold;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] medal = new int[n][4];
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			list.add(new Node(country, gold, silver, bronze, 0));
		}
		Collections.sort(list);
		list.get(0).rank = 1;
		int answer = 0;
		for (int i = 1; i < list.size(); i++) {
			int gold = list.get(i - 1).gold;
			int silver = list.get(i - 1).silver;
			int bronze = list.get(i - 1).bronze;
			Node now = list.get(i);
			if (list.get(i).ctr == k) {
				answer = i;
			}
			if (now.gold == gold && now.silver == silver && now.bronze == bronze) {
				list.get(i).rank = list.get(i - 1).rank;
			} else {
				list.get(i).rank = i + 1;
			}
		}
		System.out.println(list.get(answer).rank);
	}
}
