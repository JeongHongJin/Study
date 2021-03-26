package TeamStudy;

import java.util.Scanner;

public class n2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		for (int i = 1; i < 1000000; i++) {
			if (i < 10) {
				if (N == i + i) {
					answer = i;
					break;
				}
			} else if (i < 100) {
				if (N == i + i / 10 + i % 10) {
					answer = i;
					break;
				}
			} else if (i < 1000) {
				if (N == i + i / 100 + (i % 100) / 10 + i % 10) {
					answer = i;
					break;
				}
			} else if (i < 10000) {
				if (N == i + i / 1000 + (i % 1000) / 100 + (i % 100) / 10 + i % 10) {
					answer = i;
					break;
				}
			} else if (i < 100000) {
				if (N == i + i / 10000 + (i % 10000) / 1000 + (i % 1000) / 100 + (i % 100) / 10 + i % 10) {
					answer = i;
					break;
				}
			} else if (i < 1000000) {
				if (N == i + i / 100000 + (i % 100000) / 10000 + (i % 10000) / 1000 + (i % 1000) / 100 + (i % 100) / 10
						+ i % 10) {
					answer = i;
					break;
				}
			}
		}
		if (answer != 0) {
			System.out.println(answer);
		} else
			System.out.println(0);

		sc.close();
	}
}
