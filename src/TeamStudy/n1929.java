package TeamStudy;

import java.util.Scanner;

public class n1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean flag = false;

		for (int i = M; i <= N; i++) {
			flag = false;
			for (int j = 2; j*j <= i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}

			}
			if (flag == false && i > 1)
				System.out.println(i);
		}
		sc.close();
	}
}
