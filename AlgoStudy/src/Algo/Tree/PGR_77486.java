package Algo.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_77486 {
	class Solution {
		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			int[] answer = new int[enroll.length];
			HashMap<String, Integer> map = new HashMap<>();
			ArrayList<Integer>[] list = new ArrayList[enroll.length + 1];
			for (int i = 0; i <= enroll.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < enroll.length; i++) {
				map.put(enroll[i], i);
			}
			for (int i = 0; i < referral.length; i++) {
				if (map.containsKey(referral[i])) {
					int start = map.get(enroll[i]);
					int end = map.get(referral[i]);
					list[start].add(end);
				} else {
					int start = map.get(enroll[i]);
					list[start].add(enroll.length);
				}
			}
			for (int i = 0; i < seller.length; i++) {
				int sales = amount[i] * 100;
				if (sales == 0)
					continue;
				Queue<Integer> q = new LinkedList<>();
				int idx = map.get(seller[i]);
				q.offer(idx);
				answer[idx] += sales;
				while (!q.isEmpty()) {
					int now = q.poll();
					if (sales == 0)
						break;
					for (int next : list[now]) {
						sales /= 10;
						answer[now] -= sales;
						if (next == enroll.length)
							continue;
						q.offer(next);
						answer[next] += sales;
					}
				}

			}
			return answer;
		}
	}
}
