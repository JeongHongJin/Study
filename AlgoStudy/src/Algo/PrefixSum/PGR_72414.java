package Algo.PrefixSum;

public class PGR_72414 {
	class Solution {
		public String solution(String play_time, String adv_time, String[] logs) {
			String answer = "";
			int[] ad = new int[360000];
			for (int i = 0; i < logs.length; i++) {
				String[] log = logs[i].split("-");
				String[] stime = log[0].split(":");
				String[] etime = log[1].split(":");
				int start = Integer.parseInt(stime[0]) * 3600 + Integer.parseInt(stime[1]) * 60
						+ Integer.parseInt(stime[2]);
				int end = Integer.parseInt(etime[0]) * 3600 + Integer.parseInt(etime[1]) * 60
						+ Integer.parseInt(etime[2]);
				// 전체 PLAY시간 중 광고 중인 시간
				for (int j = start; j < end; j++) {
					ad[j]++;
				}
			}

			String[] play = play_time.split(":");
			int playTime = Integer.parseInt(play[0]) * 3600 + Integer.parseInt(play[1]) * 60
					+ Integer.parseInt(play[2]);
			String[] adv = adv_time.split(":");
			int adTime = Integer.parseInt(adv[0]) * 3600 + Integer.parseInt(adv[1]) * 60 + Integer.parseInt(adv[2]);

			int maxIdx = 0; // 최종 play 시작 시간
			long maxTime = 0; // 최대 play time
			long time = 0;

			for (int i = 0; i < adTime; i++) {
				time += ad[i];
			}
			maxTime = time;
			// 광고 시작부터 전체 play time까지
			for (int i = adTime; i < playTime; i++) {
				// 구간합 설정
				time += ad[i] - ad[i - adTime];
				// 새로운 최대치 구간 발견
				if (time > maxTime) {
					maxTime = time;
					maxIdx = i - adTime + 1;
				}
			}

			int hour = maxIdx / 3600;
			maxIdx %= 3600;
			if (hour < 10)
				answer += "0" + hour + ":";
			else
				answer += hour + ":";
			int minute = maxIdx / 60;
			maxIdx %= 60;
			if (minute < 10)
				answer += "0" + minute + ":";
			else
				answer += minute + ":";
			int sec = maxIdx;
			if (sec < 10)
				answer += "0" + sec;
			else
				answer += sec;
			return answer;
		}
	}
}
