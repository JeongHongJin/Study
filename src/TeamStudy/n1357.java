package TeamStudy;

import java.util.Scanner;

public class n1357 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer = "";
		int X = sc.nextInt();
		int Y = sc.nextInt();
		String revX = "";
		String revY = "";
		while (X > 0) {
			revX += X % 10;
			X /= 10;
		}
		while (Y > 0) {
			revY += Y % 10;
			Y /= 10;
		}
		int sum = Integer.parseInt(revX) + Integer.parseInt(revY);
		while (sum > 0) {
			answer += sum % 10;
			sum /= 10;
		}
		System.out.println(Integer.parseInt(answer));
		sc.close();
	}
}
