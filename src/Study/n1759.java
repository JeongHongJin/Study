package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n1759 {
	static int L, C;
	static char[] password;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		password = new char[C];
		visit = new boolean[C];
		for (int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(password);
		combi(0, C, L);
		for (String s : list)
			System.out.println(s);
	}

	static ArrayList<String> list = new ArrayList<>();

	static void combi(int start, int depth, int goal) {
		if (goal == 0) {
			String s = "";
			int cnt = 0;
			for (int i = 0; i < C; i++) {
				if (visit[i]) {
					s += password[i];
					if (password[i] != 'a' && password[i] != 'e' && password[i] != 'i' && password[i] != 'o'
							&& password[i] != 'u') {
						cnt++;
					}
				}
			}
			if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
				if (cnt >= 2)
					list.add(s);
			}
			return;
		}
		for (int i = start; i < C; i++) {
			visit[i] = true;
			combi(i + 1, depth + 1, goal - 1);
			visit[i] = false;
		}

	}
}
