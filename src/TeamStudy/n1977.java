package TeamStudy;

import java.util.Scanner;

public class n1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int answer = 0;
		int min = 0;
		boolean minflag = false;
		for (int i = (int) Math.sqrt(M); i <= Math.sqrt(N); i++) {
			if (Math.pow(i, 2) >= M && minflag == false) {
				minflag = true;
				min = (int) Math.pow(i, 2);
				answer += (int) Math.pow(i, 2);
			} else if (Math.pow(i, 2) >= M) {
				answer += (int) Math.pow(i, 2);
			}
		}
		if (answer > 0) {
			System.out.println(answer);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
}
