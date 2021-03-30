package Study;

import java.util.Scanner;

public class n1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int num = sc.nextInt();
			int answer = 0;
			if (num == 0) {
				break;
			} else {
				int num2 = num;
				while (num != 0) {
					answer = answer * 10 + num % 10;
					num /= 10;
				}
				if (num2 == answer) {
					System.out.println("yes");
				} else
					System.out.println("no");
			}
		}
		sc.close();
	}
}
