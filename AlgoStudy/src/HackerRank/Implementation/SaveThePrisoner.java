package HackerRank.Implementation;

public class SaveThePrisoner {
	public static int saveThePrisoner(int n, int m, int s) {
		int answer = 0;
		answer = (m + s - 1) % n;
		if (answer == 0)
			answer = n;
		return answer;
	}
}
