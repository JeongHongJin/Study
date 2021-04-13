package TeamStudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class n11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		//첫번째 원소가 같은 경우 두번째 원소 비교
		//아닌경우 첫번째 원소만 비교
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] n1, int[] n2) {
				if (n1[0] == n2[0]) {
					return n1[1] - n2[1];
				} else {
					return n1[0] - n2[0];
				}
			}
		});
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

		sc.close();
	}
}
