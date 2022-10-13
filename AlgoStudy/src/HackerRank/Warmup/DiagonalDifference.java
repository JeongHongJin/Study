package HackerRank.Warmup;

import java.util.List;

public class DiagonalDifference {
	public static int diagonalDifference(List<List<Integer>> arr) {
		int answer = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < arr.size(); i++) {
			a += arr.get(i).get(i);
			b += arr.get(i).get(arr.size() - i - 1);
		}
		answer = Math.abs(a - b);
		return answer;
	}
}
