package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = m - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr[mid] > arr2[i]) {
					right = mid - 1;
				} else if (arr[mid] < arr2[i]) {
					left = mid + 1;
				} else if (arr[mid] == arr2[i]) {
					arr2[i] = 1;
					break;
				}
			}
			if (arr2[i] != 1) {
				arr2[i] = 0;
			}
		}
		for(int i : arr2) {
			System.out.print(i+" ");
		}
	}
}
