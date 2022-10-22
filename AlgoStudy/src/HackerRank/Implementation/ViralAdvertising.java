package HackerRank.Implementation;

public class ViralAdvertising {
	public static int viralAdvertising(int n) {
		int answer = 0;
		int shared = 5;
		int liked = 0;
		for (int i = 0; i < n; i++) {
			answer += shared / 2;
			liked = shared / 2;
			shared = liked * 3;
		}
		return answer;
	}
}
