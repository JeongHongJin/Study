package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1790 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long len = 1;
		long num = 9;
		long answer = 0;
		long tmp = k;
		while (tmp > num * len) {
			tmp -= num * len; // k번째 만큼 빼기
			answer += num; // 결과 자리수 증가
			num *= 10; // 자리수 증가
			len++; // 숫자 길이 증가
		}
		answer = (answer + 1) + ((tmp - 1) / len); // 현재 까지 지나쳐온 자리수 + 해당자릿수만큼 이동한 횟수
		if (answer > n)
			System.out.println(-1);
		else {
			long idx = (tmp - 1) % len;
			System.out.println(String.valueOf(answer).charAt((int) idx));
		}
	}
}
