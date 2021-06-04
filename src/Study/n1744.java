package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		int left = 0;
		int right = n - 1;
		long sum = 0;
		// 음수
		while (left < right) {
			if (arr[left] < 1 && arr[left + 1] < 1) {
				sum += arr[left] * arr[left + 1];
			} else {
				break;
			}
			left += 2;
		}
		// 양수
		while (right > 0) {
			if (arr[right] > 1 && arr[right - 1] > 1) {
				sum += arr[right] * arr[right - 1];
			} else {
				break;
			}
			right -= 2;
		}
		// 1이 존재하는 경우 + 가 *보다 더 큰 수를 만든다
		while (right >= left) {
			sum += arr[right];
			right--;
		}
		System.out.println(sum);
	}
}
