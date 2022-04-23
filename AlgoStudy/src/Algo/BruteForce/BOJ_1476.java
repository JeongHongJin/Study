package Algo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e1 = Integer.parseInt(st.nextToken());
		int s1 = Integer.parseInt(st.nextToken());
		int m1 = Integer.parseInt(st.nextToken());
		int e2 = 1;
		int s2 = 1;
		int m2 = 1;
		int answer = 1;
		while (true) {
			if (e1 == e2 && s1 == s2 && m1 == m2) {
				break;
			}
			answer++;
			e2++;
			s2++;
			m2++;
			if (e2 == 16)
				e2 = 1;
			if (s2 == 29)
				s2 = 1;
			if (m2 == 20)
				m2 = 1;
		}
		System.out.println(answer);
	}
}
