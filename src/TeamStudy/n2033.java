package TeamStudy;

import java.util.Scanner;

public class n2033 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		while (N > 9) {
			if (N % Math.pow(10, cnt) >= Math.pow(10, cnt) / 2) {
				N = N - (int) (N % Math.pow(10, cnt)) + (int) Math.pow(10, cnt);
			} else {
				N -= N % Math.pow(10, cnt);
			}
			if (N / Math.pow(10, cnt) < 10) {
				break;
			}
			cnt++;
		}
		System.out.println(N);
		sc.close();
	}
}
