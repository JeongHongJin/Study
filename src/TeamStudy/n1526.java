package TeamStudy;

import java.util.Scanner;

public class n1526 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = N; i > 3; i--) {
			boolean flag = false;
			int num = i;
			while (num > 0) {
				if (num % 10 == 4 || num % 10 == 7) {
					num /= 10;
				} else {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}
}
