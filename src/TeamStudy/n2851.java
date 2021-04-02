package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			answer += arr[i];
			if (answer >= 100) {
				if (Math.abs(answer) - 100 > 100 - Math.abs(answer - arr[i])) {
					System.out.println(answer - arr[i]);
				} else
					System.out.println(answer);
				break;
			}

		}
		if (answer < 100)
			System.out.println(answer);
	}
}
