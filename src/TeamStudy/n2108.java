package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class n2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[8001];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
			arr[list.get(i) + 4000]++;
		}
		int max = 1;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (max == arr[i]) {
				answer = i - 4000;
				if (flag == true) {
					break;
				}
				flag = true;
			}
		}
		Collections.sort(list);
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += list.get(i);
		}
		int midcnt = N / 2;
		System.out.println(Math.round(sum / N));
		System.out.println(list.get(midcnt));
		System.out.println(answer);
		System.out.println(list.get(N - 1) - list.get(0));
	}

}
