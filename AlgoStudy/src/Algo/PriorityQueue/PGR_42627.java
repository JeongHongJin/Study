package Algo.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PGR_42627 {
	class Solution {
		public int solution(int[][] jobs) {
			int answer = 0;
			int end = 0; // 각 디스크 종료 시점
			int cnt = 0;
			int idx = 0; // jobs의 index

			// 디스크가 비어있는 경우를 방지하기 위한 시간 설정
			Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

			// 시간이 짧게 걸리는 디스크 (동시 시작되었을때)
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			while (cnt < jobs.length) {

				// 종료 시점까지 들어오는 디스크 pq에 저장
				while (idx < jobs.length && jobs[idx][0] <= end) {
					pq.offer(jobs[idx++]);
				}
				// end 이후에 들어온 디스크 처리
				if (pq.isEmpty()) {
					end = jobs[idx][0];
				} else { // pq가 있는 경우 처리
					int[] tmp = pq.poll();
					answer += tmp[1] + end - tmp[0];
					end += tmp[1];
					cnt++;
				}

			}
			return answer / jobs.length;
		}
	}
}
