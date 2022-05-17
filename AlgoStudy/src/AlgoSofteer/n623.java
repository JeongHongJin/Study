package AlgoSofteer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			sb.append(str2[i]);
		}
		String[] str3 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			sb2.append(str3[i]);
		}
		String s = sb.toString();
		String answer = sb2.toString();
		if (answer.contains(s)) {
			System.out.println("secret");
		} else {
			System.out.println("normal");
		}
	}
}
