package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left = arr[0];
		int right = arr[n - 1];
		int mid = (left + right) / 2;
		while (left <= right) {
			int sum = m;
			mid = (left + right) / 2;
			for (int i = 0; i < n; i++) {
				if (mid > arr[i]) {
					sum -= arr[i];
				} else {
					sum -= mid;
				}
			}
			if (sum < 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (mid > arr[i]) {
				m -= arr[i];
			} else {
				m -= mid;
			}
		}
		if (m < 0) {
			if (m % n == 0) {
				mid += m / n;
			} else {
				mid += m / n;
				mid--;
			}
		}
		System.out.println(mid);

	}
}
