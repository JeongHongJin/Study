package Algo.Implement;

import java.util.PriorityQueue;

public class PGR_17683 {
	class Solution {
		class now implements Comparable<now> {
			int time;
			String name;

			now(int time, String name) {
				this.time = time;
				this.name = name;
			}

			@Override
			public int compareTo(now n) {
				return n.time - this.time;
			}
		}

		public String solution(String m, String[] musicinfos) {
			String answer = "";
			StringBuilder sb = new StringBuilder();
			PriorityQueue<now> pq = new PriorityQueue<>();
			for (int i = 0; i < musicinfos.length; i++) {
				sb.setLength(0);
				String[] musicinfo = musicinfos[i].split(",");
				int time = 0;
				String[] time1 = musicinfo[0].split(":");
				String[] time2 = musicinfo[1].split(":");

				int m1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
				int m2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
				time = Math.abs(m2 - m1);
				musicinfo[3] = musicinfo[3].replaceAll("C#", "c");
				musicinfo[3] = musicinfo[3].replaceAll("D#", "d");
				musicinfo[3] = musicinfo[3].replaceAll("G#", "g");
				musicinfo[3] = musicinfo[3].replaceAll("A#", "a");
				musicinfo[3] = musicinfo[3].replaceAll("F#", "f");

				m = m.replaceAll("C#", "c");
				m = m.replaceAll("D#", "d");
				m = m.replaceAll("G#", "g");
				m = m.replaceAll("A#", "a");
				m = m.replaceAll("F#", "f");

				for (int j = 0; j < time; j++) {
					sb.append(musicinfo[3].charAt(j % musicinfo[3].length()));
				}

				if (sb.toString().contains(m)) {
					pq.add(new now(time, musicinfo[2]));
				}
			}
			if (pq.size() == 0)
				return "(None)";
			else
				return pq.poll().name;
		}
	}
}
