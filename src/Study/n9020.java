package Study;

import java.util.Scanner;

public class n9020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int n2 = n / 2;
			int x = n2;
			for (int j = n2; j < n; j++) {
				boolean flag = false;
				boolean flag2 = false;
				for (int k = 2; k * k <= j; k++) {
					if (j % k == 0) {
						flag = true;
						break;
					}
					if (x % k == 0) {
						flag2 = true;
						break;
					}
				}
				if (n == j + x && flag == false && flag2 == false) {
					System.out.print(x+" "+j);
					System.out.println();
					break;
				}
				x--;
			}
		}
		sc.close();
	}
}
