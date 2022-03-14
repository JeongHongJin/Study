package Algo.CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2143 {
	static ArrayList<Long> listA = new ArrayList<>();
	static ArrayList<Long> listB = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		long[] b = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				listA.add(sum); // A배열의 구간합
			}
		}
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				listB.add(sum); // B배열의 구간합
			}
		}
		Collections.sort(listA);
		Collections.sort(listB);

		int left = 0;
		int right = listB.size() - 1;
		long answer = 0;
		// 이분탐색
		while (left < listA.size() && right >= 0) {
			// listA는 0번부터 , listB는 m-1번부터
			long sum = listA.get(left) + listB.get(right);
			if (sum == T) {// 부분합이 맞는경우
				long tmpA = listA.get(left);
				long tmpB = listB.get(right);
				long cntA = 0;
				long cntB = 0;
				while (left < listA.size() && listA.get(left) == tmpA) { // 중복되는 A의 경우를 모두 더한다.
					cntA++;
					left++;
				}
				while (right >= 0 && listB.get(right) == tmpB) { // 중복되는 B의 경우를 모두 더한다.
					cntB++;
					right--;
				}
				answer += cntA * cntB;
			} else if (sum < T) { // A,B구간합이 같은경우가 T보다 작으면 listA를 한 칸전진
				left++;
			} else if (sum > T) { // A,B구간합이 같은경우가 T보다 크면 listB를 한 칸전진
				right--;
			}
		}
		System.out.println(answer);
	}
}
