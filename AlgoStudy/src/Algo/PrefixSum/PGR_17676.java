package Algo.PrefixSum;

public class PGR_17676 {
	class Solution {
		public int solution(String[] lines) {
			int answer = 0;
			int[] log = new int[lines.length];
			for (int i = 0; i < lines.length; i++) {
				String[] line = lines[i].split(" ");
				String[] time = line[1].split(":");
				int endTime = 0;
				endTime += Integer.parseInt(time[0]) * 60 * 60 * 1000;
				endTime += Integer.parseInt(time[1]) * 60 * 1000;
				endTime += (int) (Double.parseDouble(time[2]) * 1000);

				for (int j = i; j < lines.length; j++) {
					String[] nline = lines[j].split(" ");
					String[] ntime = nline[1].split(":");
					int nendTime = 0;
					nendTime += Integer.parseInt(ntime[0]) * 60 * 60 * 1000;
					nendTime += Integer.parseInt(ntime[1]) * 60 * 1000;
					nendTime += (int) (Double.parseDouble(ntime[2]) * 1000);
					String[] nsec = nline[2].split("s");
					int nProcessTime = (int) (Double.parseDouble(nsec[0]) * 1000);
					int nStartTime = nendTime - nProcessTime + 1;
					if (endTime + 1000 > nStartTime) {
						log[i]++;
						answer = Math.max(answer, log[i]);
					}
				}
			}
			return answer;
		}
	}
}
