package Study;

import java.util.Scanner;

public class n20126 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		int cnt = 1;
		int answer = 0;
		boolean flag = false;
		char[] t = new char[S];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x + y; j++) {
				t[j] = 1;
			}
		}
		for (int i = 1; i < t.length; i++) {

			if (t[i] == 0 && t[i - 1] == 0) {
				cnt++;
				if (cnt == M) {
					answer = i;
					flag = true;
					break;
				}
			} else
				cnt = 1;
		}
		if (flag == true) {
			System.out.println(answer);
		} else
			System.out.println(-1);
		sc.close();
	}
}
