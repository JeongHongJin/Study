package Algo.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PGR_17687 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine()) - 1;
		String result = "";
		String s = "0";
		for (int i = 1; i <= t * m; i++) {
			int num = i;
			String tmp = "";
			while (num > 0) {
				int tmpNum = num % n;
				if (tmpNum == 10) {
					tmp += 'A';
				} else if (tmpNum == 11) {
					tmp += 'B';
				} else if (tmpNum == 12) {
					tmp += 'C';
				} else if (tmpNum == 13) {
					tmp += 'D';
				} else if (tmpNum == 14) {
					tmp += 'E';
				} else if (tmpNum == 15) {
					tmp += 'F';
				} else {
					tmp += tmpNum;
				}
				num /= n;
			}
			for (int j = tmp.length() - 1; j >= 0; j--) {
				s += tmp.charAt(j);
			}
		}
		int idx = p;
		for (int i = 0; i < t; i++) {
			result += s.charAt(idx);
			idx += m;
		}
		System.out.println(result);
	}
}
