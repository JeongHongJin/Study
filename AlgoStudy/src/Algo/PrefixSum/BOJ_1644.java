package Algo.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> prime = new ArrayList<>();
		boolean flag;
		for (int i = 2; i <= n; i++) {
			flag = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				prime.add(i);
			}
		}
		int start = 0; // 시작 index
		int end = 0; // 마지막 index
		int sum = 0; // 구간합
		int answer = 0; // 경우의수
		while (true) {
			if (sum >= n) { // 구간합이 입력 값보다 커지면 시작점을 뺀다.
				sum -= prime.get(start++);
			} else if (end == prime.size()) { // 마지막 인덱스까지 도 달한경우 루프 탈출
				break;
			} else { // 구간합이 입력 값보다 작은 경우
				sum += prime.get(end++);
			}
			if (n == sum) // 입력값을 찾은경우
				answer++;
		}
		System.out.println(answer);
	}
}
