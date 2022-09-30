package Algo.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String tmp = br.readLine();
		int cnt = 0;
		while (true) {
			if (!s.contains(tmp))
				break;
			s = s.replaceFirst(tmp, "..");
			cnt++;
		}
		System.out.println(cnt);
	}
}
