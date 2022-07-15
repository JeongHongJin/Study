package Algo.Date;

import java.util.PriorityQueue;

public class PGR_17678 {
	class Solution {
		public String solution(int n, int t, int m, String[] timetable) {
			String answer = "";
			int start = 9 * 60;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < timetable.length; i++) {
				String[] tmp = timetable[i].split(":");
				int time = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
				pq.offer(time);
			}
			int cnt = 0;
			int max = n * m;
			for (int i = 0; i < n; i++) {
				int now = start;
				for (int j = 0; j < m; j++) {
					if (pq.isEmpty()) {
						break;
					}
					if (pq.peek() <= start) {
						now = pq.poll();
					}
					cnt++;
				}
				if (pq.isEmpty() && cnt == max) {
					start = now - 1;
					break;
				}
				if (pq.isEmpty()) {
					if (now <= start)
						break;
				} else if (cnt == max) {
					if (now < start)
						start = now - 1;
					break;
				}
				start += t;
			}
			answer = convert(start);
			return answer;
		}

		public String convert(int time) {
			String answer = "";
			int tmp = time / 60;
			if (tmp < 10) {
				answer += "0" + tmp + ":";
			} else {
				answer += tmp + ":";
			}
			time %= 60;
			if (time < 10) {
				answer += "0" + time;
			} else {
				answer += time;
			}
			return answer;
		}
	}
}
