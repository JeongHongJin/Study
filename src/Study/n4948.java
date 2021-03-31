package Study;

import java.util.Scanner;

public class n4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int cnt = 0;
			for (int i = n; i <= n * 2; i++) {
				boolean flag = false;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (flag == false && i != n) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
