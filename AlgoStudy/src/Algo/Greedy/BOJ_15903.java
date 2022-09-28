package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_15903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(str[i]));
		}
		for (int i = 0; i < m; i++) {
			long a = pq.poll();
			long b = pq.poll();
			long sum = a + b;
			pq.offer(sum);
			pq.offer(sum);
		}
		long answer = 0;
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
}
