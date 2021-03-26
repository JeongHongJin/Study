package TeamStudy;

import java.util.Scanner;

public class n5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = 1000 - N;
		int answer = 0;
		while (N > 0) {
			if (N >= 500) {
				answer = N / 500;
				N = N % 500;
			} else if (N >= 100) {
				answer += N / 100;
				N = N % 100;
			} else if (N >= 50) {
				answer += N / 50;
				N = N % 50;
			} else if (N >= 10) {
				answer += N / 10;
				N = N % 10;
			} else if (N >= 5) {
				answer += N / 5;
				N = N % 5;
			} else {
				answer += N / 1;
				N = 0;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
