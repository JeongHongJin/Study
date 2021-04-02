package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class n1453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hashSet.add(Integer.parseInt(st.nextToken()));
		}
		answer = N - hashSet.size();
		System.out.println(answer);
	}
}