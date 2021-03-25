package Study;

import java.util.Arrays;
import java.util.Scanner;

public class n20124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] A = new String[N];
		int[] B = new int[N];
		int max = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			String name = sc.next();
			int point = sc.nextInt();
			if (i == 0) {
				max = point;
			} else if (max < point) {
				max = point;
			}
			A[i] = name;
			B[i] = point;
		}
		for (int j = 0; j < N; j++) {
			if (max == B[j])
				cnt++;
		}
		String[] answer = new String[cnt];
		int x = 0;
		for (int k = 0; k < N; k++) {
			if (max == B[k]) {
				answer[x] = A[k];
				x++;
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[0]);
		sc.close();
	}
}
