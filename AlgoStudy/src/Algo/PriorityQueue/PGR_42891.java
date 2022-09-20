package Algo.PriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class PGR_42891 {
	class Solution {
		class Node implements Comparable<Node> {
			int idx;
			int time;

			Node(int idx, int time) {
				this.idx = idx;
				this.time = time;
			}

			public int compareTo(Node n) {
				return this.time - n.time;
			}
		}

		public int solution(int[] food_times, long k) {
			int answer = -1;
			long sum = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < food_times.length; i++) {
				sum += food_times[i];
				pq.offer(new Node(i, food_times[i]));
			}

			if (sum <= k) {
				return -1;
			}

			long cnt = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			while (!pq.isEmpty()) {
				if (pq.size() == 1) {
					return pq.peek().idx + 1;
				}
				Node now = pq.peek();
				k -= (now.time - cnt) * pq.size();
				if (k <= 0) {
					k += (now.time - cnt) * pq.size();
					break;
				}
				map.put(now.idx, 0);
				cnt = now.time;
				pq.poll();
			}
			cnt = pq.size();
			k %= cnt;

			while (k > 0) {
				for (int i = 0; i < food_times.length; i++) {
					if (map.containsKey(i))
						continue;
					k--;
					answer = i + 1;
					if (k < 0)
						return answer;
				}
			}
			if (k == 0) {
				for (int i = 0; i < food_times.length; i++) {
					if (map.containsKey(i))
						continue;
					return i + 1;
				}
			}

			return -1;
		}
	}
}
