package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int sum = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				sum = arr[i] + arr[j];
				if (sum == k) {
					answer++;
					break;
				} else if (sum < k) {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}
}
