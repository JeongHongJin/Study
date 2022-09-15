package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_17140 {
	static class Node implements Comparable<Node> {
		int idx;
		int cnt;

		Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}

		public int compareTo(Node n) {
			if (this.cnt == n.cnt) {
				return this.idx - n.idx;
			}
			return this.cnt - n.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		int[][] map = new int[102][102];
		int answer = 0;
		for (int i = 1; i <= 3; i++) {
			str = br.readLine().split(" ");
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(str[j - 1]);
			}
		}
		int rMax = 3;
		int cMax = 3;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		HashMap<Integer, Integer> num = new HashMap<>();
		while (true) {
			if (map[r][c] == k) {
				break;
			}
			if (rMax >= cMax) {
				cMax = 0;
				for (int i = 1; i <= rMax; i++) {
					for (int j = 1; j <= 100; j++) {
						if (map[i][j] == 0)
							continue;
						num.put(map[i][j], num.getOrDefault(map[i][j], 0) + 1);
					}
					for (int tmp : num.keySet()) {
						pq.offer(new Node(tmp, num.get(tmp)));
					}
					for (int j = 1; j <= 100; j += 2) {
						map[i][j] = 0;
						map[i][j + 1] = 0;
						if (pq.isEmpty())
							continue;
						Node now = pq.poll();
						map[i][j] = now.idx;
						map[i][j + 1] = now.cnt;
						cMax = Math.max(cMax, j + 1);
					}
					num.clear();
				}
			} else {
				rMax = 0;
				for (int i = 1; i <= cMax; i++) {
					for (int j = 1; j <= 100; j++) {
						if (map[j][i] == 0)
							continue;
						num.put(map[j][i], num.getOrDefault(map[j][i], 0) + 1);
					}
					for (int tmp : num.keySet()) {
						pq.offer(new Node(tmp, num.get(tmp)));
					}
					for (int j = 1; j <= 100; j += 2) {
						map[j][i] = 0;
						map[j + 1][i] = 0;
						if (pq.isEmpty())
							continue;
						Node now = pq.poll();
						map[j][i] = now.idx;
						map[j + 1][i] = now.cnt;
						rMax = Math.max(rMax, j + 1);
					}
					num.clear();
				}
			}
			answer++;
			if (answer > 100) {
				break;
			}
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					System.out.print(map[i][j] + "");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		if (answer > 100) {
			System.out.println(-1);
		} else
			System.out.println(answer);
	}
}
