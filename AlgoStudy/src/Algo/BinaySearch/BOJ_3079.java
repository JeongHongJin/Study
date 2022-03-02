package Algo.BinaySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long t = Long.parseLong(br.readLine());
			list.add(t);
		}
		Collections.sort(list);
		long start = 1;
		long end = list.get(list.size() - 1) * m;

		while (start <= end) {
			long sum = 0;
			long mid = (start + end) / 2;
			for (int i = 0; i < n; i++) {
				sum += mid / list.get(i); // 검사대 평균 시간 합
			}
			if (sum >= m) { // 검사받는 인원이 m보다 크면
				end = mid - 1;
			} else { // 검사 받는 인원이 m보다 작으면
				start = mid + 1;
			}
		}
		System.out.println(start);
	}
}
