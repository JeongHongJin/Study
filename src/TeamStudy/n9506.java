package TeamStudy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class n9506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> hashSet = new HashSet<Integer>();

		while (true) {
			int n = sc.nextInt();
			if (n == -1)
				break;
			int sum = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					hashSet.add(i);
				}
			}
			Iterator<Integer> it = hashSet.iterator();
			int[] arr = new int[hashSet.size()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = it.next();
				sum += arr[j];
			}
			Arrays.sort(arr);
			hashSet.clear();
			if (sum == n) {
				System.out.print(n + " = ");
				for (int k = 0; k < arr.length; k++) {
					System.out.print(arr[k]);
					if (k != arr.length - 1) {
						System.out.print(" + ");
					}
				}
				System.out.println();
			}else {
				System.out.println(n+" is NOT perfect.");
			}

		}
		sc.close();
	}
}
