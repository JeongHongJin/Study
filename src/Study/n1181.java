package Study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class n1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] answer = new String[N];
		sc.nextLine();// 줄버림
		for (int i = 0; i < N; i++) {
			answer[i] = sc.nextLine();
		}
		// 정렬 방식 기억하기 compare사용 앞뒤 사전순 정렬가능
		Arrays.sort(answer, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 단어 길이 같은경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2); // 사전순정렬
				} else {
					// 단어 길이 다른경우 큰게 뒤로
					return s1.length() - s2.length();
				}
			}
		});
		System.out.println(answer[0]);
		for (int i = 1; i < N; i++) {
			// 중복되지 않는 단어만 출력
			if (!answer[i].equals(answer[i - 1]))
				System.out.println(answer[i]);
		}
		sc.close();
	}
}
