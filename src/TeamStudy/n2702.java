package TeamStudy;

import java.util.Scanner;

public class n2702 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int r = 1;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int a2 = a;
			int b2 = b;
			//b가 a 보다 큰경우
			if (a < b) {
				a = b2;
				b = a2;
			}
			//유클리드 호제법 GCD 구하기
			while (r > 0) {
				r = a % b;
				a = b;
				b = r;
			}
			int Lcm = a2 * b2 / a;
			System.out.print(Lcm + " " + a);
			System.out.println();
		}
		sc.close();
	}
}
