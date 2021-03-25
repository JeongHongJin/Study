package TeamStudy;

import java.util.Scanner;

public class n2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == j + 1) {
				cnt1++;
			}
			if (arr[j] == arr.length - j) {
				cnt2++;
			}
		}
		if (cnt1 == 8) {
			System.out.println("ascending");
		} else if (cnt2 == 8) {
			System.out.println("descending");
		} else
			System.out.println("mixed");
		sc.close();
	}
}
