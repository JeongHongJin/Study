package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class n1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hashSet = new HashSet<>();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			hashSet.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hashSet.contains(s)) {
				list.add(s);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (String r : list)
			System.out.println(r);

	}
}