package Algo.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//출처: https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-10986-%EB%82%98%EB%A8%B8%EC%A7%80-%ED%95%A9
public class BOJ_10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		long[] arr = new long[n + 1];
		long[] cnt = new long[m];
		long answer = 0;
		str = br.readLine().split(" ");

		// 누적합을 M으로 나눈 나머지를 저장한다.
		for (int i = 1; i <= n; i++) {
			arr[i] = (arr[i - 1] + Integer.parseInt(str[i - 1])) % m;

			// 0은 항상 나머지가 0이된다.
			if (arr[i] == 0) {
				answer++;
			}
			// 나머지가 같은 index 카운팅

			cnt[(int) arr[i]]++;
		}
		// S[j] % M == S[i-1] % M을 만족 하는 (i,j)의 수를 결과값에 더한다.
		// cnt[i] (i가 나머지의 인덱스의 수)에서 2가지를 뽑는 경우의 수 카운팅한다.
		for (int i = 0; i < m; i++) {
			if (cnt[i] > 1) {
				answer += cnt[i] * (cnt[i] - 1) / 2;
			}
		}
		System.out.println(answer);
	}
}
