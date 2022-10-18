package HackerRank.Implementation;

public class UtopianTree {
	public static int utopianTree(int n) {
		int answer = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				answer++;
			} else if (i % 2 == 1) {
				answer *= 2;
			}
		}
		return answer;
	}
}
