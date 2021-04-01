package TeamStudy;

import java.util.Scanner;

public class n11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answer = 1;
		for (int i = N; i > N - K; i--)
			answer *= i;
		for (int i = 1; i <= K; i++)
			answer /= i;
		System.out.println(answer);
		sc.close();
	}
}
