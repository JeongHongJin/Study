package TeamStudy;

import java.util.Scanner;

public class n11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int x = 2;
		while (num > 0) {
			if (num == 1) {
				break;
			} else if (num % x == 0) {
				num /= x;
				System.out.println(x);
			} else
				x++;
		}

		sc.close();
	}
}
