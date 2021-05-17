package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] button = new int[3];
		while (T > 0) {
			if (T >= 300) {
				button[0] = T / 300;
				T = T % 300;
			} else if (T >= 60) {
				button[1] = T / 60;
				T = T % 60;
			} else if (T >= 10) {
				button[2] = T / 10;
				T = T % 10;
			} else {
				System.out.println(-1);
				return;
			}
		}
		for (int i : button)
			System.out.print(i + " ");
	}
}
