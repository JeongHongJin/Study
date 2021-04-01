package TeamStudy;

import java.util.Scanner;

public class n9093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			String s = sc.nextLine();
			String[] arr = s.split(" ");

			for (int j = 0; j < arr.length; j++) {
				String answer = "";
				for (int k = arr[j].length() - 1; k >= 0; k--) {
					answer += arr[j].charAt(k);
				}
				System.out.print(answer);
				System.out.print(" ");
			}
			System.out.println();

		}
		sc.close();
	}
}