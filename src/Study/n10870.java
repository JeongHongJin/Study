package Study;

import java.util.Scanner;

public class n10870 {
	static int fin(int n) {
		if (n > 1) {
			return fin(n - 2) + fin(n - 1);
		} else if (n == 1) {
			return 1;
		} else
			return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fin(n));
		sc.close();
	}
}
