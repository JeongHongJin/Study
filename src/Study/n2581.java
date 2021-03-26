package Study;

import java.util.Scanner;

public class n2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = 0;
		boolean minflag = false;
		if (M == N && M != 1) {
			boolean flag = false;
			for (int x = 2; x < M; x++) {
				if (M % x == 0) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				sum = M;
				min = M;
			}

		}
		for (int i = M; i <= N; i++) {
			boolean flag = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (flag == false && i>1) {
				sum += i;
				if (minflag == false) {
					min = i;
					minflag = true;
				}
			}
		}
		if (sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else
			System.out.println(-1);
		sc.close();
	}
}
