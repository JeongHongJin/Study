package HackerRank.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ClimbingTheLeaderboard {
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Write your code here
		List<Integer> answer = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < ranked.size(); i++) {
			set.add(ranked.get(i));
		}
		ranked.clear();
		for (int i : set) {
			ranked.add(i);
		}
		Collections.sort(ranked);
		loop: for (int i = 0; i < player.size(); i++) {
			int start = 0;
			int end = ranked.size() - 1;
			int mid = (start + end) / 2;
			while (start <= end) {
				mid = (start + end) / 2;
				if (ranked.get(mid) == player.get(i)) {
					answer.add(ranked.size() - mid);
					continue loop;
				} else if (ranked.get(mid) > player.get(i)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			answer.add(ranked.size() + 1 - start);
		}
		return answer;
	}
}
