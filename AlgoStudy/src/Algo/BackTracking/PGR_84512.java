package Algo.BackTracking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PGR_84512 {
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		boolean[] visit = new boolean[5];
		String[] str = { "A", "E", "I", "O", "U" };
		String[] out = new String[5];
		perm(5, 0, str, out, visit);
		out = new String[4];
		perm(4, 0, str, out, visit);
		out = new String[3];
		perm(3, 0, str, out, visit);
		out = new String[2];
		perm(2, 0, str, out, visit);
		out = new String[1];
		perm(1, 0, str, out, visit);
		Collections.sort(list);
		for (String s : list)
			System.out.println(s);
	}

	static void perm(int n, int depth, String[] str, String[] out, boolean[] visit) {
		if (n == depth) {
			String tmp = "";
			for (String s : out)
				tmp += s;
			list.add(tmp);
			return;
		}
		for (int i = 0; i < 5; i++) {
			out[depth] = str[i];
			perm(n, depth + 1, str, out, visit);
		}
	}
}
