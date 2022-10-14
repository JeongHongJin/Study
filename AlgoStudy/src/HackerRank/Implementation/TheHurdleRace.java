package HackerRank.Implementation;

import java.util.List;

public class TheHurdleRace {
	public static int hurdleRace(int k, List<Integer> height) {
		// Write your code here
		int answer = 0;
		int max = 0;
		for (int i = 0; i < height.size(); i++) {
			max = Math.max(height.get(i), max);
		}
		if (k >= max)
			return 0;
		else
			return max - k;
	}
}
