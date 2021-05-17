package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int left = 1;
		int right = arr[n - 1] - arr[0];
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int start = arr[0];
			for (int i = 1; i < n; i++) {
				// 간격이 최소인 경우
				if (arr[i] - start >= mid) {
					cnt++;
					start = arr[i];
				}
			}
			if (cnt >= c) {
				// 설치를 c의 갯수보다 많이 하는 경우 오른쪽 탐색
				answer = mid;
				left = mid + 1;
			} else {
				// 공유기를 c보다 적게 설치한 경우 왼쪽 탐색
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
