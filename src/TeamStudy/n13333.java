package TeamStudy;

import java.util.Arrays;
import java.util.Scanner;

public class n13333 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < arr.length+1; i++) {
			int cnt = 0;
			int cnt2 = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] >= i) {
					cnt++;
				}
				if (arr[j] <= i) {
					cnt2++;
				}
			}
			if (cnt >= i && n - i <= cnt2) {
				answer = i;
				System.out.println(answer);
				break;
			}
		}
		sc.close();
	}
}
