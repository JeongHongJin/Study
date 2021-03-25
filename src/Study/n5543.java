package Study;

import java.util.Scanner;

public class n5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
		}

		int min = a[0];
		int min2 = a[3];

		for (int j = 0; j < 3; j++) {
			if (min > a[j])
				min = a[j];
		}
		for (int k = 3; k < 5; k++) {
			if (min2 > a[k])
				min2 = a[k];
		}
		System.out.println(min + min2 - 50);
		sc.close();
	}
}
