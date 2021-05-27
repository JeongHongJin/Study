package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = n;
		int sum = 0;
		int end = 0;
		int cnt = 0;
		for (int start = 0; start < n; start++) {
			// s보다 큰 부분 수열 찾기
			while (sum < s && end < n) {
				System.out.println(sum);
				sum += arr[end];
				end++;
			}
			// 합이 s이상인 경우
			if (sum >= s) {
				cnt++;
				// min 갱신
				if (end - start < min) {
					min = end - start;
				}
			}
			// start가 1씩 증가하므로 증가한 start 빼준다
			sum -= arr[start];
		}
		if (cnt == 0)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
