package HackerRank.Implementation;

import java.util.List;

public class AngryProfessor {
	public static String angryProfessor(int k, List<Integer> a) {
		int cnt = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) <= 0) {
				cnt++;
			}
		}
		if (cnt >= k)
			return "NO";
		else
			return "YES";
	}
}
