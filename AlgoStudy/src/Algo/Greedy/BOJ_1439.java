package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] str = s.split("1");
		String[] str2 = s.split("0");
		int a = 0;
		int b = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			a++;
		}
		for (int i = 0; i < str2.length; i++) {
			if (str2[i].equals(""))
				continue;
			b++;
		}
		System.out.println(Math.min(a, b));
	}
}
