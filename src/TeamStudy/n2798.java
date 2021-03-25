package TeamStudy;

import java.util.Arrays;
import java.util.Scanner;

public class n2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer1 = 0;
		int answer2 = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		for (int x = 0; x < card.length; x++) {
			card[x] = sc.nextInt();
		}
		int cnt = N * (N - 1) * (N - 2) / 6;
		int[] cntarr = new int[cnt];
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					cntarr[cnt2] = card[i] + card[j] + card[k];
					cnt2++;
				}
			}
		}
		Arrays.sort(cntarr);
		for (int y = 0; y < cnt; y++) {
			if (cntarr[y] <= M) {
				answer1 = cntarr[y];
			}
		}
		System.out.println(answer1);
		sc.close();
	}
}
