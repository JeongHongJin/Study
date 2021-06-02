package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		int cnt = 1;
		int max = 1;
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			if (max < cnt) {
				max = cnt;
				index = i;
			}
		}
		System.out.println(arr[index]);
	}
}
